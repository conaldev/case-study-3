package DAO.Account;

import model.Account;

import java.sql.SQLException;

public interface IAccount {
     boolean innsertAccount(Account account) throws SQLException;
     boolean checkAccount(Account account) throws SQLException;
     boolean changePassword(Account account,String newPassword) throws SQLException;
     boolean checkAdmin(Account account) throws SQLException;
     boolean deleteAccount(Account account) throws SQLException;
}
