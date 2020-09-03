package dao;

import model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDao implements IDAO<Order> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSl=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

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
        return null;
    }

    @Override
    public void insert(Order order) {

    }

    @Override
    public boolean update(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
