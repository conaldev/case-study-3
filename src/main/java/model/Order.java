package model;

public class Order {
    private int orderNumber;
    private int productID;
    private int quanityOrdered;
    private long priceProduct;
    private int cusNumber;
    private String orderDate;
    private String status;

    public Order(){}

    public Order(int orderNumber, int productID, int quanityOrdered, long priceProduct, int cusNumber, String orderDate, String status) {
        this.orderNumber = orderNumber;
        this.productID = productID;
        this.quanityOrdered = quanityOrdered;
        this.priceProduct = priceProduct;
        this.cusNumber = cusNumber;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuanityOrdered() {
        return quanityOrdered;
    }

    public void setQuanityOrdered(int quanityOrdered) {
        this.quanityOrdered = quanityOrdered;
    }

    public long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getCusNumber() {
        return cusNumber;
    }

    public void setCusNumber(int cusNumber) {
        this.cusNumber = cusNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
