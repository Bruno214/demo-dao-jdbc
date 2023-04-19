package model.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn = null;
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

            // verificando se tenho o id buscado no banco de dados
            if (resultSet.next()) {
                Department dep = new Department();
                dep.setId(resultSet.getInt("DepartmentId"));
                dep.setName(resultSet.getString("DepName"));

                Seller seller = new Seller();
                seller.setId(resultSet.getInt("Id"));
                seller.setName(resultSet.getString("Name"));
                seller.setEmail(resultSet.getString("Email"));
                seller.setBirthDate(resultSet.getDate("BirthDate"));
                seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
                seller.setDepartment(dep);

                return seller;
            }
            // retornado null pois não foi encontrado o vendedor na base de dados
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeConnection(preparedStatement, resultSet);
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
