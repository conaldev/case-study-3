package Controller;

import model.Account;
import model.Product;
import model.User;
import DAO.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private DAOManager daoManager;

    public void init() {
        daoManager = new DAOManager();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    doLogin(request, response);
                    break;
                case "changepassword":
                    changePass(request, response);
                    break;
                case "signup":
                    createAccount(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "changepassword":
                    System.out.println("go to Change Password Form .....");
                    showChangePasswordForm(request, response);
                    break;
                case "signup":
                    System.out.println("....go to sign up Form.....");
                    showSignUpForm(request,response);
                    break;
                default:
                    showLogin(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");
        Account account = new Account(newEmail, newPassword);
        System.out.println("email = " + newEmail);
        System.out.println("password = " + newPassword);
        String status = "";
        try {
            if (daoManager.accountDAO.insertAccount(account)) {
                System.out.println("Successful! Created Account !");
                status = "Successful! Created Account ! ";
            } else {
                System.out.println("Failed!Can't create account");
                status = "Failed!Can't create account";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("status",status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/WEB-INF/views/login/SignUp.jsp");
        dispatcher.forward(request, response);
    }
    private void changePass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newpassword");
        Account account = new Account(email, password);
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        System.out.println("newPassword = " + newPassword);
        String status = "";

        if (daoManager.accountDAO.changePassword(account, newPassword)) {
            System.out.println("Successful! Password Changed! ");
            status = "Successful! Password Changed! ";
        } else {
            System.out.println("Failed!Can't change password");
            status = "Failed!Can't change password";
        }
        request.setAttribute("status",status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/WEB-INF/views/login/changepassword.jsp");
        dispatcher.forward(request, response);
    }


    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login/login.jsp");
        dispatcher.forward(request, response);

    }
    private void showSignUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login/SignUp.jsp");
        dispatcher.forward(request, response);
    }


    private void showChangePasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login/changepassword.jsp");
        dispatcher.forward(request, response);

    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account account = new Account(email, password);
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        String message = "";
        RequestDispatcher dispatcher = null;
        List<Product> listProduct = daoManager.productDAO.selectAllProduct();
        User user = daoManager.userDAO.selectUserByEmail(email);

        if (daoManager.accountDAO.checkAccount(account)) {
            request.setAttribute("listProduct", listProduct);
//            request.setAttribute("user", user);
            request.setAttribute("daoManager",daoManager);

//            dispatcher = request.getRequestDispatcher("WEB-INF/views/home/index.jsp");
            dispatcher = request.getRequestDispatcher("product/list.jsp");
            System.out.println("LOG IN SUCCESS !");
            message = "LOG IN SUCCESS !";
            if (daoManager.accountDAO.checkAdmin(account)) {
                System.out.println(account + "is admin account");
                dispatcher = request.getRequestDispatcher("product/list.jsp");
            } else {
                System.out.println(account + " is not admin account");

            }
        } else {
            dispatcher = request.getRequestDispatcher("product/list.jsp");
            System.out.println("Wrong password or email !");
            message = "Wrong password or email !";
        }
        request.setAttribute("message", message);
        dispatcher.forward(request, response);

    }

}
