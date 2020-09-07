package DAO.user;

import DAO.database.Jdbc;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private static final String INSERT_USER_SQL = "INSERT INTO Users" +
            " (userFullName,userPhoneNumber,userAddress,userEmail) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM Users where userNumber = ?;";

    private static final String SELECT_USER_BY_EMAIL_SQL = "SELECT * FROM Users where userEmail = ?;";

    private static final String SELECT_ALL_USER_SQL = "SELECT * FROM Users";

    private static final String DELETE_USER_BY_ID_SQL = "DELETE FROM Users WHERE userNumber = ?;";

    private static final String UPDATE_USER_SQL = "UPDATE Users SET " +
            "userFullName = ?, userPhoneNumber = ? , userAddress = ?, userEmail = ?" +
            "where userNumber = ?;";
    public UserDAO() {}
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Jdbc.getInstance().getJdbcURL(), Jdbc.getInstance().getJdbcUser(), Jdbc.getInstance().getJdbcPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
        try {
            System.out.println("creating new User");
            preparedStatement.setString(1,user.getUserFullName());
            preparedStatement.setString(2,user.getUserPhoneNumber());
            preparedStatement.setString(3,user.getUserAddress());
            preparedStatement.setString(4,user.getUserEmail());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public User selectUserById(int userNumber) throws SQLException {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_SQL);
        preparedStatement.setInt(1,userNumber);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String userFullName = resultSet.getString("userFullName");
            String userPhoneNumber = resultSet.getString("userPhoneNumber");
            String userAddress = resultSet.getString("userAddress");
            String userEmail = resultSet.getString("userEmail");
            user = new User(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
        }
        return user;
    }

    @Override
    public User selectUserByEmail(String userEmail) throws SQLException {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL);
        preparedStatement.setString(1,userEmail);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String userFullName = resultSet.getString("userFullName");
            String userPhoneNumber = resultSet.getString("userPhoneNumber");
            String userAddress = resultSet.getString("userAddress");
            int userNumber = resultSet.getInt("userNumber");
            user = new User(userNumber,userFullName,userPhoneNumber,userAddress,userEmail);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER_SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int userNumber = resultSet.getInt("userNumber");
            String userFullName = resultSet.getString("userFullName");
            String userPhoneNumber = resultSet.getString("userPhoneNumber");
            String userAddress = resultSet.getString("userAddress");
            String userEmail = resultSet.getString("userEmail");
            users.add(new User(userNumber,userFullName,userPhoneNumber,userAddress,userEmail));
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted ;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID_SQL);
        statement.setInt(1,id);
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
        preparedStatement.setString(1,user.getUserFullName());
        preparedStatement.setString(2,user.getUserPhoneNumber());
        preparedStatement.setString(3,user.getUserAddress());
        preparedStatement.setString(4,user.getUserEmail());
        preparedStatement.setInt(5,user.getUserNumber());
        rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
    }
}
