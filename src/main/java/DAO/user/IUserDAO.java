package DAO.user;

import model.Account;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
         boolean insertCustomer(User user) throws SQLException;

         User selectUser(int id) throws SQLException;

         User selectCustomer(String userEmail) throws SQLException;

         List<User> selectAllUsers() throws SQLException;

         boolean deleteUser(int id) throws SQLException;

         boolean updateUser(User user) throws SQLException;
}
