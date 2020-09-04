package dao;

import model.Order;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IDAO<Order> {
    
    private  static final String INSERT_ORDER_SQL = "INSERT INTO orders" +
            " (transaction_id, id, product_id, qty, amount, status) VALUES" +"(?,?,?,?,?,?);";
    //    private static final String SELECT_ORDER_BY_ID = "select id,name,email,country from orders where id =?;";
    private static final String SELECT_ALL_ORDER = "select * from orders;";
    private static final String DELETE_ORDER_SQL = "delete from orders where id = ?;";
    private static final String UPDATE_ORDER_SQL = "update orders set transaction_id = ?,  id = ?,  product_id = ?, qty = ?, amount = ?, status = ?  where id = ?;";
//    private static final String FIND_ORDER_BY_COUNTRY = "select * from orders where country = ?;";
//    private static final String SORT_BY_NAME = "select * from orders order by name;";

    @Override
    public List<Order> selectAll() {
        List<Order> order = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int transaction_id = rs.getInt("transaction_id");
                int id = rs.getInt("id");
                int product_id = rs.getInt("product_id");
                int qty = rs.getInt("qty");
                double amount = rs.getDouble("amount");
                int status = rs.getInt("status");

                order.add(new Order(transaction_id, id, product_id, qty, amount, status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void insert(Order order) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);){
            preparedStatement.setInt(1,order.getTransaction_id());
            preparedStatement.setInt(3,order.getProduct_id());
            preparedStatement.setInt(4,order.getQty());
            preparedStatement.setDouble(5,order.getAmount());
            preparedStatement.setInt(6,order.getStatus());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Order order) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL);) {
            statement.setInt(1,order.getTransaction_id());
            statement.setInt(2,order.getId());
            statement.setInt(3,order.getProduct_id());
            statement.setInt(4,order.getQty());
            statement.setDouble(5,order.getAmount());
            statement.setInt(6,order.getStatus());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
