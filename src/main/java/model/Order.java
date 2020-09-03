package model;

public class Order {
    private int transaction_id;
    private int id;
    private int product_id;
    private int qty;
    private double amount;
    private int status;

    public Order(int transaction_id, int id, int product_id, int qty, double amount, int status) {
        this.transaction_id = transaction_id;
        this.id = id;
        this.product_id = product_id;
        this.qty = qty;
        this.amount = amount;
        this.status = status;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

