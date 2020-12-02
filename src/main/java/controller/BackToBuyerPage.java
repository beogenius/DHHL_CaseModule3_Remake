package controller;

import dao.IProductDao;
import dao.IUserDao;
import dao.impl.IProductDaoImpl;
import dao.impl.IUserDaoImpl;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BackToBuyerPage", urlPatterns = "/back-to-buyer-page")
public class BackToBuyerPage extends HttpServlet {

    IProductDao productDao = new IProductDaoImpl();
    IUserDao userDao = new IUserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("buyer", buyer);
        List<Product> products = productDao.listAllProduct();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/buyerPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
