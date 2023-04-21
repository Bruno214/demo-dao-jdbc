package model.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Department findById(int id) {
        preparedStatement = null;
        resultSet = null;

        // preparando e executando o comando em sql
        try {
            String sql = "SELECT * FROM department where id = ?";
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            // verificando se achei o departamento no banco de dados
            if (resultSet.next()) {
                return instantiateDepartment(resultSet);
            }

            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeConnection(preparedStatement, resultSet);
        }
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department dep = new Department();
        dep.setId(resultSet.getInt("Id"));
        dep.setName(resultSet.getString("Name"));

        return dep;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
