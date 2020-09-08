package Controller;

import DAO.DAOManager;
import model.Account;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class UserServlet extends HttpServlet {
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
                case "create":
                    System.out.println("start create user");
                    insertUser(request, response);
                    break;
                case "edit":
                    System.out.println("start update user");
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
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
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "Search":
                    showSearchResult(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> listUser = daoManager.userDAO.selectAllUsers();
        System.out.println("user list size = " + listUser.size());
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchResult(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        User user = daoManager.userDAO.selectUserById(userNumber);
        request.setAttribute("user",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/users/delete.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        User user = daoManager.userDAO.selectUserById(userNumber);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userFullName = request.getParameter("userFullName");
        String userPhoneNumber = request.getParameter("userPhoneNumber");
        String userAddress = request.getParameter("userAddress");
        String userEmail = request.getParameter("userEmail");
        String userNumber = request.getParameter("userNumber");
        String password = request.getParameter("password");
        User newUser = new User(userFullName, userPhoneNumber, userAddress, userEmail);
        Account newAccount = new Account(userEmail, password);
        String status;
        if (daoManager.accountDAO.insertAccount(newAccount) && daoManager.userDAO.insertUser(newUser)){
            status = "SUCCESS!! CREATED!";
        } else {
            status = "FAIL ! NOT CREATED!";
        }
        request.setAttribute("status",status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/create.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        User user = daoManager.userDAO.selectUserById(userNumber);
        Account account = new Account();
        String status;
        if (daoManager.userDAO.deleteUser(userNumber)&& daoManager.accountDAO.deleteAccount(daoManager.accountDAO.selectAccountByEmail(user.getUserEmail()))){
            status = "SUCCESS! DELETED!";
        } else {
            status =" NOT DELETED!";
        }
        request.setAttribute("status",status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/users/delete.jsp");
        requestDispatcher.forward(request, response);
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String userFullName = request.getParameter("userFullName");
        String userPhoneNumber = request.getParameter("userPhoneNumber");
        String userAddress = request.getParameter("userAddress");
        String userEmail = request.getParameter("userEmail");
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        User user = new User(userNumber,userFullName,userPhoneNumber, userAddress, userEmail);
        daoManager.userDAO.updateUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/users/edit.jsp");
        dispatcher.forward(request, response);
    }
}
