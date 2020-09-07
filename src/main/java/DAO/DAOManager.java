package DAO;

import DAO.Account.AccountDAO;
import DAO.cart.CartDAO;
import DAO.order.OrderDAO;
import DAO.product.ProductDAO;
import DAO.user.UserDAO;

public class DAOManager {
    public final CartDAO cartDAO = new CartDAO();
    public final UserDAO userDAO = new UserDAO();
    public final OrderDAO orderDAO = new OrderDAO();
    public final ProductDAO productDAO = new ProductDAO();
    public final AccountDAO accountDAO = new AccountDAO();
}
