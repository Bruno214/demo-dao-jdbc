package db;

import java.sql.*;

public class DB {
    private final static String URL = "jdbc:mysql://localhost:3306/coursejdbc";
    private final static String USER = "developer";
    private final static String PASSWORD = "1234567";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexao Aberta");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new DbException("Erro na conexão com o banco de dados " + e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão fechada");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Connection conn, Statement statement, ResultSet resultSet) {
        if (conn != null && statement != null && resultSet != null) {
            try {
                statement.close();
                resultSet.close();
                conn.close();
                System.out.println("Conexão fechada");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Statement statement, ResultSet resultSet) {
        if (statement != null && resultSet != null) {
            try {
                statement.close();
                resultSet.close();
                System.out.println("Conexão fechada");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
