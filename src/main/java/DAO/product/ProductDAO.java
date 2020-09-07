package DAO.product;

import DAO.database.Jdbc;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String INSERT_PRODUCT_SQL ="INSERT INTO product" +
            " (productName,price,description,imgURL,Vendor) values (?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select productName,price,description,imgURL, Vendor from Product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String DELETE_PRODUCT_BY_ID_SQL = "delete from Product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update Product set productName = ?,price= ?, description =?,imgURL=?, Vendor = ? where id = ?;";

    public ProductDAO(){};
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
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getImgURL());
            preparedStatement.setString(5, product.getVendor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                String Vendor = resultSet.getString("Vendor");
                long price = resultSet.getLong("price");
                String description = resultSet.getString("description");
                String imgURL = resultSet.getString("imgURL");

                product = new Product(id, productName, price, description, imgURL, Vendor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
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
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID_SQL);
        statement.setInt(1, id);
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setLong(2, product.getPrice());
        preparedStatement.setString(3, product.getDescription());
        preparedStatement.setString(4, product.getImgURL());
        preparedStatement.setString(5, product.getVendor());
        preparedStatement.setInt(6, product.getId());

        rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
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
