package caseStudy.model;

public class Cart {
    private int cusNumber;
    private int productID;
    private int quanity;

    public Cart(int cusNumber, int productID, int quantity) {
        this.cusNumber = cusNumber;
        this.productID = productID;
        this.quanity = quantity;
    }

    public int getCusNumber() {
        return cusNumber;
    }

    public void setCusNumber(int cusNumber) {
        this.cusNumber = cusNumber;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuantity(int quantity) {
        this.quanity = quantity;
    }
}
