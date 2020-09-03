package dao;

import model.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminDao implements IDAO<Admin> {
    private final String jdbcURL= "jdbc:mysql://localhost:3306/demo?useSSl=false";
    private final String jdbcUserName="root";
    private final String jdbcPassword="123456";

    private static final String SELECT_ALL_ADMIN = "select * from admin";
    private static final String DELETE_ADMIN_BY_ID = "delete from admin where = ?;";
    private static final String UPDATE_ADMIN_SQL = "update admin set id=?, name=?, passWord=? ";

    @Override
    public List<Admin> selectAll() {
        return null;
    }

    @Override
    public void insert(Admin admin) {

    }

    @Override
    public boolean update(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
