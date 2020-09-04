package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
        final String jdbcURL = "jdbc:mysql://localhost:3306/weblaptop?useSSl=false";
        final String jdbcUsername = "root";
        final String jdbcPassword = "123456";
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null )
            System.out.println("Thanh cong");
                else
                    System.out.println("that bai");
    }
}
