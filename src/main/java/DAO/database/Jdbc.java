package DAO.database;

public class Jdbc {
    private  String jdbcURL = "jdbc:mysql://localhost:3306/webLaptop?useSSL=false";
    private  String jdbcUser = "root";
    private  String jdbcPassword = "123456";
    private static volatile Jdbc instance;
    public static Jdbc getInstance(){
        if(instance==null){
            instance = new Jdbc();
        }
        return  instance;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }
}
