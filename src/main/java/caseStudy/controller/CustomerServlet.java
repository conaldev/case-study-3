package caseStudy.controller;

import caseStudy.dao.CustomerDao.CustomerDao;
import caseStudy.dao.CustomerDao.ICustomerDao;
import caseStudy.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private final ICustomerDao customerDao = new CustomerDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "search":
                findCustomerById(request, response);
                break;
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showNewCustomer(request,response);
                    break;
                case "update":
                    showUpdateCustomer(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                case "sortID":
                    sortCustomer(request, response);
                    break;
                default:
                    listCustomer(request,response);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException();
        }
    }

    private void sortCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDao.sortID();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/view.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerCode = Integer.parseInt(request.getParameter("customerCode"));
        customerDao.delete(customerCode);
        List<Customer> customerList = customerDao.selectAll();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerCode = Integer.parseInt(request.getParameter("customerCode"));
        Customer existingCustomer =  customerDao.selectById(customerCode);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/update.jsp");
        request.setAttribute("showUpdate",existingCustomer);
        dispatcher.forward(request,response);
    }

    private void showNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDao.selectAll();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/view.jsp");
        dispatcher.forward(request, response);
    }

    private void findCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerCode = Integer.parseInt(request.getParameter("customerCode"));
        Customer customerList =  customerDao.selectById(customerCode);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/view.jsp");
        dispatcher.forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerCode  = Integer.parseInt(request.getParameter("customerCode"));
        Customer existingCustomer =  customerDao.selectById(customerCode);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/update.jsp");
        request.setAttribute("showUpdate",existingCustomer);
        dispatcher.forward(request,response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        Customer customer = new Customer(userName, password, userNumber);
        customerDao.insert(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/create.jsp");
        dispatcher.forward(request,response);
    }
}
