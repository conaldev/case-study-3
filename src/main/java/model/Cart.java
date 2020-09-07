package model;

public class Cart {
    private int cusNumber;
    private int productID;
    private int quanity;

    public Cart(){}

    public Cart(int cusNumber, int productID, int quanity) {
        this.cusNumber = cusNumber;
        this.productID = productID;
        this.quanity = quanity;
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

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
