package caseStudy.controller;

import caseStudy.dao.ProductDao.IProductDao;
import caseStudy.dao.ProductDao.ProductDao;
import caseStudy.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet" , urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private final IProductDao productDao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "search":
                    findProductById(request, response);
                    break;

            }
        } catch (SQLException ex){
            throw new ServletException();
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
                    showNewProduct(request,response);
                    break;
                case "update":
                    showUpdateProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                case "sortASC":
                    sortProductASC(request, response);
                    break;
                case "sortDESC":
                    sortProductDESC(request, response);
                    break;
                default:
                    listProduct(request,response);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException();
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = productDao.selectAll();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/view.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("imgUrl");
//        String Vendor = request.getParameter("Vendor");
        Product product = new Product(productName, price, description,imgUrl);
        productDao.insert(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/create.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/create.jsp");
        dispatcher.forward(request,response);
    }



    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("imgUrl");
//        String Vendor = request.getParameter("Vendor");
        Product product = new Product(id, productName, price, description,imgUrl);
        productDao.update(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/update.jsp");
        dispatcher.forward(request,response);
    }
    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id  = Integer.parseInt(request.getParameter("id"));
        Product existingProduct =  productDao.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/update.jsp");
        request.setAttribute("showUpdate",existingProduct);
        dispatcher.forward(request,response);
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDao.delete(id);
        List<Product> productList = productDao.selectAll();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/view.jsp");
        dispatcher.forward(request, response);
    }

    private void findProductById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productDao.findID(id);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/view.jsp");
        dispatcher.forward(request,response);

    }


    private void sortProductASC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDao.sortPriceASC();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/view.jsp");
        dispatcher.forward(request,response);
    }


    private void sortProductDESC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDao.sortPriceDESC();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product/view.jsp");
        dispatcher.forward(request,response);
    }
}