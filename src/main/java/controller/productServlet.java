package controller;

import dao.IDAO;
import dao.ProductDao;
import model.List;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class productServlet extends HttpServlet {
    private IDAO productDao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                insertProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
        }
    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showNewProduct(request,response);
                break;
            case "update":
                showUpdateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productDao.
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }
}
