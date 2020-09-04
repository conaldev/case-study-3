package model;

public class Product {
    private int id;
    private String name;
<<<<<<< HEAD
//    private String vendor;
    private String description;
    private long price;

    public Product(int id, String name, String description, long price) {
        this.id = id;
        this.name = name;
//        this.vendor = vendor;
=======
    private String vendor;
    private String description;
    private long price;

    public Product(String name, String vendor, String description, long price) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
>>>>>>> 337e8f699f2ec9bf803741269a52631ebeb78d00
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
//    public String getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(String vendor) {
//        this.vendor = vendor;
//    }
=======
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
>>>>>>> 337e8f699f2ec9bf803741269a52631ebeb78d00

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
<<<<<<< HEAD

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
=======
>>>>>>> 337e8f699f2ec9bf803741269a52631ebeb78d00
}
