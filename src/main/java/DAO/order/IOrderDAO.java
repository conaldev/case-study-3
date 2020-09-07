package DAO.order;

import model.Order;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
     void insertOrder(Order order) throws SQLException;

     Integer getOrderNumber() throws SQLException;

     List<Order> selectOrder(User user) throws SQLException;
}
