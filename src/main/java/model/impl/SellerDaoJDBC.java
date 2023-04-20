package model.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(int id) {
        System.out.println("apaguei o id: " + id);
    }


    // buscar um vendedor por id
    @Override
    public Seller findById(int id) {
        // abrir a conexao com o banco de dados
        conn = DB.getConnection();

        // preparando o comando em sql
        String sql = "SELECT seller.*, department.Name as DepName from " +
                "seller inner join department " +
                "on seller.DepartmentId = department.Id " +
                "WHERE seller.id = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // executando a query
            resultSet = preparedStatement.executeQuery();

            // verificando se tenho o id buscado no banco de dados, se tenho o retorno
            if (resultSet.next()) {
                Department dep = instantiateDepartment(resultSet);
                return instantiateSeller(resultSet, dep);
            }
            // retornado null pois não foi encontrado o vendedor na base de dados
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            System.out.println("conexao fechadaaaaaaaaaaaa");
            DB.closeConnection(preparedStatement, resultSet);
        }
    }

    // metodo auxiliar para fazer a instanciação de um objeto Department
    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department dep = new Department();
        dep.setId(resultSet.getInt("DepartmentId"));
        dep.setName(resultSet.getString("DepName"));
        return dep;
    }

    // metodo auxiliar para fazer a instanciação de um objeto seller
    private Seller instantiateSeller(ResultSet resultSet, Department dep) throws SQLException {
        Seller seller = new Seller();

        seller.setId(resultSet.getInt("Id"));
        seller.setName(resultSet.getString("Name"));
        seller.setEmail(resultSet.getString("Email"));
        seller.setBirthDate(resultSet.getDate("BirthDate"));
        seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
        seller.setDepartment(dep);
        return seller;
    }

    // dado um id retornar uma lista de sellers desde departamento
    @Override
    public List<Seller> findByDepartment(Department department) {

        // preparando o comando de acesso ao banco
        String sql = "select seller.*, department.Name as DepName from " +
                "seller inner join department " +
                "on seller.DepartmentId = department.Id " +
                "where department.Id = ? " +
                "order by Name";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, department.getId());
            resultSet = preparedStatement.executeQuery();

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(resultSet.next()) {
                Department dep = map.get(resultSet.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(resultSet);
                    map.put(resultSet.getInt("DepartmentId"), dep);
                }

                Seller seller = instantiateSeller(resultSet, dep);
                sellers.add(seller);
            }

            return sellers;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection(preparedStatement, resultSet);
        }
    }

    // listar todos os vendedores
    @Override
    public List<Seller> findAll() {
        Statement statement = null;
        resultSet = null;

        try {
            // preparando o comando sql

            String sql = "SELECT seller.*, department.Name as DepName FROM seller " +
                    "INNER JOIN department " +
                    "on seller.DepartmentId = department.Id " +
                    "order by seller.Name;";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(resultSet.next()) {

                Department dep = map.get(resultSet.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(resultSet);
                    map.put(resultSet.getInt("DepartmentId"), dep);
                }

                Seller seller = instantiateSeller(resultSet, dep);
                sellers.add(seller);
            }

            return sellers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeConnection(statement, resultSet);
        }
    }
}
