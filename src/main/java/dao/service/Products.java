package dao.service;

import model.Product;

import java.util.ArrayList;

public class Products {
    private static Products products = new Products();
    private static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<Product> getProductList(){
        return productList;
    }
}
