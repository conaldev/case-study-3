package DAO.user;

import model.Account;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
         boolean insertUser(User user) throws SQLException;

         User selectUserById(int id) throws SQLException;

         User selectUserByEmail(String userEmail) throws SQLException;

         List<User> selectAllUsers() throws SQLException;

         boolean deleteUser(int id) throws SQLException;

         boolean updateUser(User user) throws SQLException;
}
