package caseStudy.dao.CustomerDao;

import caseStudy.dao.JDBCConnection;
import caseStudy.model.Customer;
import caseStudy.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" +
            " (userName,password) VALUES" +"(?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where id =?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set userName = ?, password = ? WHERE id = ?;";
    private static final String FIND_CUSTOMER_BY_USERNAME = "select * from customer where userName = ?;";
    private static final String SORT_CUSTOMER = "select * from customer order by customerCode;";


    @Override
    public List<Customer> selectAll() {
        List<Customer> customers = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int customerCode = rs.getInt("customerCode");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                int userNumber = rs.getInt("userNumber");
                customers.add(new Customer(customerCode,userName,password,userNumber));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public void insert(Customer customer) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);){
            preparedStatement.setString(1,customer.getUserName());
            preparedStatement.setString(2,customer.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Customer selectById(int customerCode) {
        Customer customer = null ;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);){
            preparedStatement.setInt(1, customerCode);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                int userNumber = rs.getInt("userNumber");
                customer = new Customer(customerCode,userName,password,userNumber);
            }
        } catch (SQLException ex){
            printSQLException(ex);
        }
        return customer;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1,customer.getUserName());
            statement.setString(2,customer.getPassword());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> sortID() {
        List<Customer> customers  = new ArrayList<>();
        try ( Connection connection = JDBCConnection.getJDBCConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SORT_CUSTOMER);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customerCode = rs.getInt("customerCode");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                int userNumber = rs.getInt("userNumber");
                customers.add(new Customer(customerCode, userName, password, userNumber));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
