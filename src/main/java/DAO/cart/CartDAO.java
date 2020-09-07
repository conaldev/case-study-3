package DAO.cart;

import DAO.database.Jdbc;
import model.Cart;
import model.Product;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO{
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM Cart where productID = ?";
    private static final String UPDATE_PRODUCT_SQL = "update Cart set quantity = ? where productID = ? and cusNumber = ?; ";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Cart (cusNumber,productID) values (?,?) ;";
    private static final String SELECT_CART_BY_CUSNUMBER = "SELECT * FROM Cart where cusNumber = ?;";
    private static final String CLEAR_CART_BY_CUSNUMBER = "delete from Cart where cusNumber = ?;";
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
    public CartDAO(){}
    @Override
    public void insertCart(User user, Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement updateStm = connection.prepareStatement(UPDATE_PRODUCT_SQL);
        PreparedStatement insertStm = connection.prepareStatement(INSERT_PRODUCT_SQL);
        int quantity = getQuantity(product);
        try {
            if (quantity > 0) {
                updateStm.setInt(1, (quantity + 1));
                updateStm.setInt(2, product.getId());
                updateStm.setInt(3, user.getUserNumber());
                updateStm.executeUpdate();
            } else {
                insertStm.setInt(1, user.getUserNumber());
                insertStm.setInt(2, product.getId());
                insertStm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getQuantity(Product product) throws SQLException {
        int quantity = 0;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
        preparedStatement.setInt(1, product.getId());
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()) {
            quantity = set.getInt("quantity");
        }
        return quantity;
    }

    @Override
    public List<Cart> selectAllCart(User user) throws SQLException {
        List<Cart> carts = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_CUSNUMBER);
        preparedStatement.setInt(1, user.getUserNumber());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int cusNumber = resultSet.getInt("cusNumber");
            int productID = resultSet.getInt("productID");
            int quantity = resultSet.getInt("quantity");
            carts.add(new Cart(productID, cusNumber, quantity));
        }
        return carts;
    }

    @Override
    public void clearCart(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CLEAR_CART_BY_CUSNUMBER);
        preparedStatement.setInt(1, user.getUserNumber());
        preparedStatement.executeUpdate();
    }
}
