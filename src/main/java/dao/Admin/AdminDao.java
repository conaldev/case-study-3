package dao.Admin;

import dao.JDBCConnection;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements IAdminDao {
    private static final String INSERT_ADMIN_SQL = "insert into admin" + 
            "(id, name,userName, passWord) VALUES" + "(?,?,?,?)";
    private static final String SELECT_ALL_ADMIN = "select * from admin;";
    private static final String DELETE_ADMIN_BY_ID = "delete from admin where = ?;";
    private static final String UPDATE_ADMIN_SQL = "update admin set id=?, name=?, passWord=? ";

    @Override
    public List<Admin> selectAll() {
        List<Admin> admin = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMIN);){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                admin.add(new Admin(id,name,userName,passWord));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return admin;
    }

    @Override
    public void insert(Admin admin) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL);){
            preparedStatement.setInt(1,admin.getId());
            preparedStatement.setString(2,admin.getName());
            preparedStatement.setString(3,admin.getUserName());
            preparedStatement.setString(4,admin.getPassWord());
            preparedStatement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    
    }

    @Override
    public boolean update(Admin admin) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
            statement.setInt(1,admin.getId());
            statement.setString(2,admin.getName());
            statement.setString(3,admin.getUserName());
            statement.setString(4,admin.getPassWord());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_BY_ID);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Admin selectById(int id) {
        return null;
    }
}
