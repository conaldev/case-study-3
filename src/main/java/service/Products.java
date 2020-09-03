package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static Products products = new Products();
    private static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<Product> getProductList(){
        return productList;
    }
}
