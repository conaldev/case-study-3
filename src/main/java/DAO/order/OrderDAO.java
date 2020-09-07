package DAO.order;

import DAO.database.Jdbc;
import model.Order;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    private static final String GET_ORDER = "select max(orderNumber) from Orderdetail;";

    private static final String INSERT_ORDER = "insert into Orderdetail (productID,quantityOrdered,priceProduct,orderDate,cusNumber,status) values (?,?,?,?,?,?);";

    private static final String SELECT_ORDER_BY_CUSNUMBER = "SELECT * FROM OrderDetail WHERE cusNumber = ?;";
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
    public void insertOrder(Order order) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER);
        try{
            System.out.println("....insert order....");
            System.out.println(">>order number: " + order.getOrderNumber() );
            System.out.println(">>product ID: " + order.getProductID()   );
            System.out.println(">>customer number: " + order.getCusNumber() );
            preparedStatement.setInt(1, order.getProductID());
            preparedStatement.setInt(2, order.getQuantityOrdered());
            preparedStatement.setLong(3, order.getPriceProduct());
            preparedStatement.setString(4, order.getOrderDate());
            preparedStatement.setInt(5, order.getCusNumber());
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getOrderNumber() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(GET_ORDER);
        int num=0;
        if (set.next()) {
            num = set.getInt(1);
        }
        return num;
    }

    @Override
    public List<Order> selectOrder(User user) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_CUSNUMBER);
        try{
            System.out.println("GETTING order.....");
            System.out.println(">>order number: " + user.getUserNumber() );
            preparedStatement.setInt(1,user.getUserNumber());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderNumber = resultSet.getInt("orderNumber");
                int productID = resultSet.getInt("productID");
                int cusNumber = resultSet.getInt("cusNumber");
                int quantityOrdered = resultSet.getInt("quantityOrdered");
                String status = resultSet.getString("status");
                String orderDate = resultSet.getString("orderDate");
                long priceProduct = resultSet.getLong("priceProduct");
                orderList.add(new Order(productID,orderNumber,quantityOrdered,priceProduct,orderDate,cusNumber,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
