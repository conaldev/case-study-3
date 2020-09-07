package caseStudy.model;

import java.util.PrimitiveIterator;

public class Customer {
    private int customerCode;
    private String userName;
    private String password;
    private int userNumber;

    public Customer(String userName, String password, int userNumber) {
        this.userName = userName;
        this.password = password;
        this.userNumber = userNumber;
    }

    public Customer(int customerCode, String userName, String password) {
        this.customerCode = customerCode;
        this.userName = userName;
        this.password = password;
    }

    public Customer(int customerCode, String userName, String password, int userNumber) {
        this.customerCode = customerCode;
        this.userName = userName;
        this.password = password;
        this.userNumber = userNumber;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
}
