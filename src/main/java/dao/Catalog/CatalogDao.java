package dao.Catalog;

import dao.JDBCConnection;
import model.Catalog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDao implements ICatalogDao {

    private  static final String INSERT_CATALOG = "INSERT INTO catalog" +
            " (id, name) VALUES" +"(?,?);";
    //    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_CATALOG = "select * from catalog;";
    private static final String DELETE_CATALOG_SQL = "delete from catalog where id = ?;";
    private static final String UPDATE_CATALOG_SQL = "update catalog set name = ? where id = ?;";
    //    private static final String FIND_USER_BY_COUNTRY = "select * from users where country = ?;";
//    private static final String SORT_BY_NAME = "select * from users order by name;";

    @Override
    public List<Catalog> selectAll() {
        List<Catalog> catalog = new ArrayList<>();
        try(
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATALOG);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                catalog.add(new Catalog(id,name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return catalog;
    }



    @Override
    public void insert(Catalog catalog) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATALOG);){
            preparedStatement.setInt(1,catalog.getId());
            preparedStatement.setString(2,catalog.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Catalog catalog) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CATALOG_SQL);) {
            statement.setInt(1,catalog.getId());
            statement.setString(2,catalog.getName());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATALOG_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Catalog selectById(int id) {
        return null;
    }
}
