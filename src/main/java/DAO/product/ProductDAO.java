package DAO.product;

import DAO.Jdbc;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String INSERT_PRODUCT_SQL ="INSERT INTO Product" +
            " (productName,price,description,imgURL,Vendor) (?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select productName,price,description,imgURL, Vendor from Product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String DELETE_PORDUCT_SQL = "delete from Product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update Product set productName = ?,price= ?, description =?,imgURL=?, Vendor = ? where id = ?;";

    public ProductDAO(){};
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("DAO.Jdbc.Driver");
            connection = DriverManager.getConnection(Jdbc.getInstance().getJdbcURL(), Jdbc.getInstance().getJdbcUser(), Jdbc.getInstance().getJdbcPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertProduct(Product product) throws SQLException {

    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                long price = rs.getLong("price");
                String description = rs.getString("description");
                String imgURL = rs.getString("imgURL");
                String Vendor = rs.getString("Vendor");
                products.add(new Product(id, productName,price, description,imgURL,Vendor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
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
