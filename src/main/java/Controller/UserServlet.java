//package Controller;
//
//import DAO.DAOManager;
//import model.Account;
//import model.User;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet(name = "UserServlet",urlPatterns = "/users")
//public class UserServlet extends HttpServlet {
//    private DAOManager daoManager;
//
//    public void init() {
//        daoManager = new DAOManager();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    System.out.println("start create user");
//                    insertCustomer(request, response);
//                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//
//        try {
//            switch (action) {
//                case "create":
//                    showNewForm(request,response);
//                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    showDeleteForm(request, response);
//                    break;
//                case "Search":
//                    showSearchResult(request, response);
//                    break;
//                default:
//                    listUser(request, response);
//                    break;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        String userFullName = request.getParameter("userFullName");
//        String userPhoneNumber = request.getParameter("userPhoneNumber");
//        String userAddress = request.getParameter("userAddress");
//        String userEmail = request.getParameter("userEmail");
//        String userNumber = request.getParameter("userNumber");
//        String password = request.getParameter("password");
//        User newUser = new User(userFullName, userPhoneNumber, userAddress, userEmail);
//        Account newAccount = new Account(userEmail, password);
//        String status;
//        if (daoManager.accountDAO.insertAccount(newAccount) && daoManager.userDAO.insertUser(newUser)){
//            status = "SUCCESS!! CREATED!";
//        } else {
//            status = "FAIL ! NOT CREATED!";
//        }
//        request.setAttribute("status",status);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/create.jsp");
//        dispatcher.forward(request, response);
//    }
//}
