package model;

public class Account {
    private String email;
    private String password;
    private int roleNumber;

    public Account(){}

    public Account(String email, String password, int roleNumber) {
        this.email = email;
        this.password = password;
        this.roleNumber = roleNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(int roleNumber) {
        this.roleNumber = roleNumber;
    }
}
