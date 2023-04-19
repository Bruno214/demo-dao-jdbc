package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
