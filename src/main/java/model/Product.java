package model;

public class Product {
    private int id;
    private String productName;
    private long price;
    private String description;
    private String imgURL;
    private String vendor;

    public Product(String productName, long price, String description, String imgURL, String vendor) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imgURL = imgURL;
        this.vendor = vendor;
    }

    public Product(int id, String productName, long price, String description, String imgURL, String vendor) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imgURL = imgURL;
        this.vendor = vendor;
    }

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
