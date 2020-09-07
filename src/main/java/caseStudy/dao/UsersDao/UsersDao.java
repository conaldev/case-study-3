package caseStudy.dao.UsersDao;

import caseStudy.dao.JDBCConnection;
import caseStudy.model.Customer;
import caseStudy.model.Product;
import caseStudy.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements IUsersDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            " (userFullName,userPhoneNumber, userAddress, userEmail) VALUES" +"(?,?,?,?);";
    private static final String SELECT_USERS_BY_ID = "select * from users where userNumber =?";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where userNumber = ?;";
    private static final String UPDATE_USERS_SQL = "update users set userFullName = ? ,userPhoneNumber = ?, userAddress = ?, userEmail =? WHERE userNumber = ?;";
    private static final String FIND_USERS = "select * from users where userNumber = ? or userFullName = ? or userPhoneNumber = ? or userEmail = ? ;";
    private static final String SORT_USERS_Name = "select * from users order by userFullName;";

    @Override
    public List<Users> selectAll() {
        List<Users> users = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int userNumber = rs.getInt("userNumber");
                String userFullName = rs.getString("userFullName");
                String userPhoneNumber = rs.getString("userPhoneNumber");
                String userAddress = rs.getString("userAddress");
                String userEmail = rs.getString("userEmail");
                users.add(new Users(userNumber,userFullName,userPhoneNumber, userAddress, userEmail));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void insert(Users users) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
            preparedStatement.setString(1,users.getUserFullName());
            preparedStatement.setString(2,users.getUserPhoneNumber());
            preparedStatement.setString(3,users.getUserAddress());
            preparedStatement.setString(4,users.getUserEmail());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }

    }

    @Override
    public Users selectById(int userNumber) {
        Users users = null ;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);){
            preparedStatement.setInt(1, userNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userFullName = rs.getString("userFullName");
                String userPhoneNumber = rs.getString("userPhoneNumber");
                String userAddress = rs.getString("userAddress");
                String userEmail = rs.getString("userEmail");
//                String Vendor = rs.getString("Vendor");
                users = new Users(userFullName,userPhoneNumber,userAddress,userEmail);
            }
        } catch (SQLException ex){
            printSQLException(ex);
        }
        return users;
    }

    @Override
    public boolean update(Users users) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1,users.getUserFullName());
            statement.setString(2,users.getUserPhoneNumber());
            statement.setString(3,users.getUserAddress());
            statement.setString(4,users.getUserEmail());
            statement.setInt(5,users.getUserNumber());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int userNumber) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
            statement.setInt(1,userNumber);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//    @Override
//    public Users findUsers() {
//        Users users = null;
//        try (Connection connection = JDBCConnection.getJDBCConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS);){
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                int userNumber = rs.getInt("userNumber");
//                String userFullName = rs.getString("userFullName");
//                String userPhoneNumber = rs.getString("userPhoneNumber");
//                String userAddress = rs.getString("userAddress");
//                String userEmail = rs.getString("userEmail");
//                users = new Users(userNumber,userFullName,userPhoneNumber, userAddress, userEmail);
//            }
//
//        } catch (SQLException ex){
//            printSQLException(ex);
//        }
//        return users;
//    }
//
//    @Override
//    public Users findUsers() {
//        return null;
//    }

    @Override
    public Users findID(int userNumber) {
        Users users = null;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS);){
            preparedStatement.setInt(1,userNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userFullName = rs.getString("userFullName");
                String userPhoneNumber = rs.getString("userPhoneNumber");
                String userAddress = rs.getString("userAddress");
                String userEmail = rs.getString("userEmail");
                users =new Users(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
            }
        } catch (SQLException ex){
            printSQLException(ex);
        }
        return users;
    }

//    @Override
//    public Users findName(String userFullName) {
//        Users users = null;
//        try(Connection connection = JDBCConnection.getJDBCConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS);){
//            preparedStatement.setString(2,userFullName);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                int userNumber = rs.getInt("userNumber");
////                String userFullName = rs.getString("userFullName");
//                String userPhoneNumber = rs.getString("userPhoneNumber");
//                String userAddress = rs.getString("userAddress");
//                String userEmail = rs.getString("userEmail");
//                users =new Users(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
//            }
//        } catch (SQLException ex){
//            printSQLException(ex);
//        }
//        return users;
//    }
//
//    @Override
//    public Users findPhone(String userPhoneNumber) {
//        Users users = null;
//        try(Connection connection = JDBCConnection.getJDBCConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS);){
//            preparedStatement.setString(3,userPhoneNumber);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                int userNumber = rs.getInt("userNumber");
//                String userFullName = rs.getString("userFullName");
////                String userPhoneNumber = rs.getString("userPhoneNumber");
//                String userAddress = rs.getString("userAddress");
//                String userEmail = rs.getString("userEmail");
//                users =new Users(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
//            }
//        } catch (SQLException ex){
//            printSQLException(ex);
//        }
//        return users;
//    }
//
//    @Override
//    public Users findEmail(String userEmail) {
//        Users users = null;
//        try(Connection connection = JDBCConnection.getJDBCConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS);){
//            preparedStatement.setString(4,userEmail);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                int userNumber = rs.getInt("userNumber");
//                String userFullName = rs.getString("userFullName");
//                String userPhoneNumber = rs.getString("userPhoneNumber");
//                String userAddress = rs.getString("userAddress");
////                String userEmail = rs.getString("userEmail");
//                users =new Users(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
//            }
//        } catch (SQLException ex){
//            printSQLException(ex);
//        }
//        return users;
//    }

    @Override
    public List<Users> sortName() {
        List<Users> users  = new ArrayList<>();
        try ( Connection connection = JDBCConnection.getJDBCConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_Name);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userNumber = rs.getInt("userNumber");
                String userFullName = rs.getString("userFullName");
                String userPhoneNumber = rs.getString("userPhoneNumber");
                String userAddress = rs.getString("userAddress");
                String userEmail = rs.getString("userEmail");
                users.add(new Users(userNumber,userFullName,userPhoneNumber, userAddress, userEmail));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return users ;
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
