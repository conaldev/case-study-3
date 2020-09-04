package model;

import java.util.Date;

public class Product {
    private int id;
    private String productName;
    private long price;
    private String description;
    private String imgUrl;
    private String Vendor;

    public Product(int id, String productName, long price, String description, String imgUrl, String Vendor) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
        this.Vendor = Vendor;
    }
    //    public Product(int id, String name, String description, long price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        this.Vendor = vendor;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
