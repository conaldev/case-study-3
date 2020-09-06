package caseStudy.dao.ProductDao;
import caseStudy.dao.JDBCConnection;
import caseStudy.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product" +
            " (productName,price, description, imgUrl) VALUES" +"(?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,productName,price,description,imgURL from product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set productName = ? ,price = ?, description = ?, imgUrl =? WHERE id = ?;";
    private static final String FIND_PRODUCT_BY_ID = "select * from product where id = ?;";
    private static final String SORT_PRICE_ASC = "select * from product order by price ASC;";
    private static final String SORT_PRICE_DESC = "select * from product order by price DESC;";

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
//                String Vendor = rs.getString("Vendor");
                products.add(new Product(id,productName,price, description, imgUrl));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }

    @Override
    public void insert(Product product) {
        System.out.println(INSERT_PRODUCT_SQL);
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);){
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setString(4, product.getImgUrl());
//            preparedStatement.setString(6,product.getVendor());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1,product.getProductName());
            statement.setString(2,product.getPrice());
            statement.setString(3,product.getDescription());
            statement.setString(4, product.getImgUrl());
            statement.setInt(5,product.getId());
//            statement.setString(6,product.getVendor());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Product selectById(int id) {
        Product products = null ;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
//                String Vendor = rs.getString("Vendor");
                products = new Product(id,productName,price,description,imgUrl);
            }
        } catch (SQLException ex){
            printSQLException(ex);
        }
        return products;
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

    @Override
    public List<Product> findID(int id) {
        List<Product> products = new ArrayList<>();
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                products.add(new Product(id,productName,price,description,imgUrl));
            }
        } catch (SQLException ex){
            printSQLException(ex);
        }
        return products;
    }

    @Override
    public List<Product> sortPriceASC() {
        List<Product> products  = new ArrayList<>();
        try ( Connection connection = JDBCConnection.getJDBCConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SORT_PRICE_ASC);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                products.add(new Product(id, productName, price, description,imgUrl));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }

    @Override
    public List<Product> sortPriceDESC() {
        List<Product> products  = new ArrayList<>();
        try ( Connection connection = JDBCConnection.getJDBCConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SORT_PRICE_DESC);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                products.add(new Product(id, productName, price, description,imgUrl));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }
}

