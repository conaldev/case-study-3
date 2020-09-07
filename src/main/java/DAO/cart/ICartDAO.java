package DAO.cart;

import model.Cart;
import model.Product;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface ICartDAO {
     void insertCart(User user, Product product) throws SQLException;

     Integer getQuantity(Product product) throws SQLException;

     List<Cart> selectAllCart(User user) throws SQLException;

     void clearCart(User user) throws SQLException;
}
