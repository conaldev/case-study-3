package caseStudy.model;

import java.util.Date;

public class OrderDetail {
    private int productID;
    private int orderNumber;
    private int quanity;
    private int priceProduct;
    private Date createDate;

    public OrderDetail(int productID, int orderNumber, int quanity, int priceProduct, Date createDate) {
        this.productID = productID;
        this.orderNumber = orderNumber;
        this.quanity = quanity;
        this.priceProduct = priceProduct;
        this.createDate = createDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
