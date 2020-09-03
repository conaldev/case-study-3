package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IDAO<Product> {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/demoCaseStudy?useSSl=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO product" +
            " (id, name,description, price) VALUES" +"(?,?,?,?);";
    //    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from product;";
    private static final String DELETE_USERS_SQL = "delete from product where id = ?;";
    private static final String UPDATE_USERS_SQL = "update product set " +
            " (id, name, description, price) VALUES" +"(?,?,?,?);";
//    private static final String FIND_USER_BY_COUNTRY = "select * from product where country = ?;";
//    private static final String SORT_BY_NAME = "select * from product order by name;";

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                long price = rs.getLong("price");

                products.add(new Product(id,name,description, price));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }

    @Override
    public void insert(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setLong(4,product.getPrice());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setInt(1,product.getId());
            statement.setString(2,product.getName());
            statement.setString(3,product.getDescription());
            statement.setLong(4,product.getPrice());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
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
