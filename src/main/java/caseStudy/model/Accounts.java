package caseStudy.model;

public class Accounts {
    private String email;
    private String password;
    private int userNumber;

    public Accounts(String email, String password, int userNumber) {
        this.email = email;
        this.password = password;
        this.userNumber = userNumber;
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

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
}
