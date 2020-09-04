package dao.Transaction;

import dao.JDBCConnection;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDao implements ITransactionDao {

    private  static final String INSERT_TRANSACTION_SQL = "INSERT INTO transaction" +
            " (id, status, user_id, user_name,\n" +
            " user_email, user_phone, amount,\n" +
            " payment, payment_info, message,\n" +
            " security, created) VALUES" +"(?,?,?,?,?,?,?,?,?,?,?,?);";
    //    private static final String SELECT_ORDER_BY_ID = "select id,name,email,country from orders where id =?;";
    private static final String SELECT_ALL_TRANSACTION = "select * from transaction;";
    private static final String DELETE_TRANSACTION_SQL = "delete from transaction where id = ?;";
    private static final String UPDATE_TRANSACTION_SQL = "update transaction set * where id = ?;";
    //    private static final String FIND_ORDER_BY_COUNTRY = "select * from orders where country = ?;";
//    private static final String SORT_BY_NAME = "select * from orders order by name;";


    @Override
    public List<Transaction> selectAll() {
        List<Transaction> transactions = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String status = rs.getString("status");
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String user_email = rs.getString("user_email");
                String user_phone = rs.getString("user_phone");
                double amount = rs.getDouble("amount");
                String payment = rs.getString("payment");
                String payment_info = rs.getString("payment_info");
                String message = rs.getString("message");
                String security = rs.getString("security");
                Date created = rs.getDate("created");

                transactions.add(new Transaction(id,status,user_id, user_name,user_email,user_phone,amount,
                        payment,payment_info,message,security,created));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return transactions;
    }


    @Override
    public void insert(Transaction transaction) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION_SQL);){
            preparedStatement.setInt(1,transaction.getId());
            preparedStatement.setString(2,transaction.getStatus());
            preparedStatement.setInt(3,transaction.getUser_id());
            preparedStatement.setString(4,transaction.getUser_name());
            preparedStatement.setString(5,transaction.getUser_email());
            preparedStatement.setString(6,transaction.getUser_phone());
            preparedStatement.setDouble(7,transaction.getAmount());
            preparedStatement.setString(8,transaction.getPayment());
            preparedStatement.setString(9,transaction.getPayment_info());
            preparedStatement.setString(10,transaction.getMessage());
            preparedStatement.setString(11,transaction.getSecurity());
            preparedStatement.setDate(12, (java.sql.Date) transaction.getCreated());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Transaction transaction) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_TRANSACTION_SQL);) {
            statement.setInt(1,transaction.getId());
            statement.setString(2,transaction.getStatus());
            statement.setInt(3,transaction.getUser_id());
            statement.setString(4,transaction.getUser_name());
            statement.setString(5,transaction.getUser_email());
            statement.setString(6,transaction.getUser_phone());
            statement.setDouble(7,transaction.getAmount());
            statement.setString(8,transaction.getPayment());
            statement.setString(9,transaction.getPayment_info());
            statement.setString(10,transaction.getMessage());
            statement.setString(11,transaction.getSecurity());
            statement.setDate(12, (java.sql.Date) transaction.getCreated());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TRANSACTION_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Transaction selectById(int id) {
        return null;
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
