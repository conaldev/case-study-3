package caseStudy.controller;

import caseStudy.dao.UsersDao.IUsersDao;
import caseStudy.dao.UsersDao.UsersDao;
import caseStudy.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private final IUsersDao usersDao = new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUsers(request, response);
                    break;
                case "update":
                    updateUsers(request, response);
                    break;
                case "search":
//                    findUsers(request, response);
                    findID(request,response);
//                    findName(request,response);
//                    findPhone(request,response);
//                    findEmail(request,response);
                    break;
            }
        }
        catch(SQLException ex){
            throw new ServletException();
        }
    }

    private void findID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        Users usersList = usersDao.findID(userNumber);
        request.setAttribute("usersList", usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
        dispatcher.forward(request,response);
    }
//    private void findName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userFullName = request.getParameter("userFullName");
//        Users usersList = usersDao.findName(userFullName);
//        request.setAttribute("usersList", usersList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
//        dispatcher.forward(request,response);
//    }
//    private void findPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userPhoneNumber = request.getParameter("id");
//        Users usersList = usersDao.findPhone(userPhoneNumber);
//        request.setAttribute("usersList", usersList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
//        dispatcher.forward(request,response);
//    }
//    private void findEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userEmail  = request.getParameter("id");
//        Users usersList = usersDao.findEmail(userEmail);
//        request.setAttribute("usersList", usersList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
//        dispatcher.forward(request,response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null){
                action = "";
            }
            try {
                switch (action){
                    case "create":
                        showNewUsers(request,response);
                        break;
                    case "update":
                        showUpdateUsers(request,response);
                        break;
                    case "delete":
                        deleteUsers(request,response);
                        break;
                    case "sortName":
                        sortUsersName(request, response);
                        break;
//
                    default:
                        listUsers(request,response);
                        break;
                }
            } catch (SQLException ex){
                throw new ServletException();
            }

        }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Users> usersList = usersDao.selectAll();
        request.setAttribute("usersList",usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String userFullName = request.getParameter("userFullName");
        String userPhoneNumber = request.getParameter("userPhoneNumber");
        String userAddress = request.getParameter("userAddress");
        String userEmail = request.getParameter("userEmail");
//        String Vendor = request.getParameter("Vendor");
        Users users = new Users(userFullName, userPhoneNumber, userAddress,userEmail);
        usersDao.insert(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/create.jsp");
        dispatcher.forward(request,response);
    }
    
    private void showNewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/create.jsp");
        dispatcher.forward(request,response);
    }



    private void updateUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        String userFullName = request.getParameter("userFullName");
        String userPhoneNumber = request.getParameter("userPhoneNumber");
        String userAddress = request.getParameter("userAddress");
        String userEmail = request.getParameter("userEmail");
        Users users = new Users(userNumber, userFullName, userPhoneNumber, userAddress,userEmail);
        usersDao.update(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/update.jsp");
        dispatcher.forward(request,response);
    }
    private void showUpdateUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        Users existingUsers =  usersDao.selectById(userNumber);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/update.jsp");
        request.setAttribute("showUpdate",existingUsers);
        dispatcher.forward(request,response);
    }


    private void deleteUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        usersDao.delete(userNumber);
        List<Users> usersList = usersDao.selectAll();
        request.setAttribute("usersList",usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
        dispatcher.forward(request, response);
    }

//    private void findUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
//        Users usersList = usersDao.findUsers();
//        request.setAttribute("usersList", usersList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
//        dispatcher.forward(request,response);
//
//    }


    private void sortUsersName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> usersList = usersDao.sortName();
        request.setAttribute("usersList",usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/view.jsp");
        dispatcher.forward(request,response);
    }
}
