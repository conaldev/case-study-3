package DAO.Account;

import DAO.database.Jdbc;
import model.Account;
import model.User;

import java.sql.*;

public class AccountDAO implements IAccountDAO {
    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO Accounts (email, password) VALUES " +
            " (?, ?);";

    private static final String GET_ACCOUNT_BY_EMAIL = "SELECT * FROM Accounts where email = ?;";

    private static final String SET_NEW_PASSWORD = "UPDATE Accounts set password = ? where email = ?;";

    private static final String GET_ROLE = "SELECT role from Accounts  where email = ?;";

    private static final String DELETE_ACCOUNT_BY_EMAIL = "delete from Accounts where email = ?;";
    private static final String SELECT_ACCOUNT_BY_EMAIL = "select * from Accounts where email = ?;";

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
    public boolean insertAccount(Account account) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL);
        try {
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean checkAccount(Account account) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_EMAIL);
        preparedStatement.setString(1, account.getEmail());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            if (email.equals(account.getEmail()) && password.equals(account.getPassword()))
                return true;
        } 
        return false;
    }

    @Override
    public boolean changePassword(Account account, String newPassword) throws SQLException {
        boolean changed = false;
        Connection connection = getConnection();
        if (checkAccount(account)) {
            System.out.println("changing pass ");
            System.out.println("account = " + account.getEmail());
            System.out.println("newPassword = " + newPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(SET_NEW_PASSWORD);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.executeUpdate();
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean checkAdmin(Account account) throws SQLException {
        boolean isAdmin = false;
        Connection connection = getConnection();
        if (checkAccount(account)) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE);
            preparedStatement.setString(1, account.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isAdmin = resultSet.getBoolean(1);
            }
        }
        return isAdmin;
    }

    @Override
    public boolean deleteAccount(Account account) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_BY_EMAIL);
        preparedStatement.setString(1, account.getEmail());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public Account selectAccountByEmail(String email) throws SQLException {
        Account account = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String password = resultSet.getString("password");
            int role = resultSet.getInt("role");
            account = new Account(email,password,role);
        }
        return account;
    }
}
