package DAO.user;

import DAO.database.Jdbc;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    public boolean insertCustomer(User user) throws SQLException {
        return false;
    }

    @Override
    public User selectUser(int id) throws SQLException {
        return null;
    }

    @Override
    public User selectCustomer(String userEmail) throws SQLException {
        return null;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
