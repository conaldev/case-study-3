package dao;

import model.Catalog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDao implements IDAO<Catalog> {

    private  static final String INSERT_CATALOG = "INSERT INTO catalog" +
            " (id, name, parent_id) VALUES" +"(?,?,?);";
    //    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_CATALOG = "select * from catalog;";
    private static final String DELETE_CATALOG_SQL = "delete from catalog where id = ?;";
    private static final String UPDATE_CATALOG_SQL = "update catalog set name = ? where id = ?;";
    //    private static final String FIND_USER_BY_COUNTRY = "select * from users where country = ?;";
//    private static final String SORT_BY_NAME = "select * from users order by name;";

    @Override
    public List<Catalog> selectAll() {
//        List<Catalog> catalogs = new ArrayList<>();
//        try(Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATALOG)){
//
//        }

        return null;
    }



    @Override
    public void insert(Catalog catalog) {

    }

    @Override
    public boolean update(Catalog catalog) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
