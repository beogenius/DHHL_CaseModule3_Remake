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

@WebServlet(name = "SearchProductByName", urlPatterns = "/search-products-by-name")
public class SearchProductByName extends HttpServlet {

    IProductDao productDao = new IProductDaoImpl();
    IUserDao userDao = new IUserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        List<Product> products = productDao.findProductsByName(productName);
        request.setAttribute("products", products);
        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("buyer", buyer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/searchProductsByName.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
