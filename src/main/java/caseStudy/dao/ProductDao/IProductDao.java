package caseStudy.dao.ProductDao;

import caseStudy.dao.IDAO;
import caseStudy.model.Product;

import java.util.List;

public interface IProductDao extends IDAO<Product> {
    List<Product> findID(int id) ;
    List<Product> sortPriceASC();
    List<Product> sortPriceDESC();
}
