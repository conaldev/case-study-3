package DAO.cart;

import DAO.database.Jdbc;
import model.Cart;
import model.Product;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CartDAO implements ICartDAO{
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM Cart where productCode = ?";
    private static final String UPDATE_ADD1_PRODUCT_SQL = "update Cart set quantity = ? where productCode = ? and cusNumber = ?; ";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Cart (cusNumber,productCode) values (?,?) ;";
    private static final String SELECT_CART_BY_CUS_NUMBER = "SELECT * FROM Cart where cusNumber = ?;";
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

    }

    @Override
    public Integer getQuantity(Product product) throws SQLException {
        return null;
    }

    @Override
    public List<Cart> selectAllCart(User user) throws SQLException {
        return null;
    }

    @Override
    public void clearCart(User user) throws SQLException {

    }
}
