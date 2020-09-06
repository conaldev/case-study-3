package caseStudy.dao.UsersDao;

import caseStudy.dao.IDAO;
import caseStudy.model.Product;
import caseStudy.model.Users;

import java.util.List;

public interface IUsersDao extends IDAO<Users> {
    Users findUsers();
    Users findID(int id) ;
    Users findName(String name) ;
    Users findPhone(String phone) ;
    Users findEmail(String email) ;
    List<Users> sortName();


}
