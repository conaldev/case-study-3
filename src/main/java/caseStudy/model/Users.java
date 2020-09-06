package caseStudy.model;

public class Users {
    private int userNumber;
    private String userFullName;
    private String userPhoneNumber;
    private String userAddress;
    private String userEmail;
    private String roleCode;

    public Users(String userFullName, String userPhoneNumber, String userAddress, String userEmail, String roleCode) {
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.roleCode = roleCode;
    }

    public Users(int userNumber, String userFullName, String userPhoneNumber, String userAddress, String userEmail, String roleCode) {
        this.userNumber = userNumber;
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.roleCode = roleCode;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRoleCole() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
