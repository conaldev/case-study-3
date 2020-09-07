package caseStudy.dao.CustomerDao;

import caseStudy.dao.IDAO;
import caseStudy.model.Customer;

import java.util.List;

public interface ICustomerDao extends IDAO<Customer> {
    List<Customer> sortID();
}
