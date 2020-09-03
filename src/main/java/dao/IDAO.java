package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    //CRUD
    List<T> selectAll();
    void insert(T t);
    boolean update(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
}
