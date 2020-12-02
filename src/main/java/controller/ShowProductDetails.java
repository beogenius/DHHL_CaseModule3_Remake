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

@WebServlet(name = "ShowProductDetails", urlPatterns = "/show-product-details")
public class ShowProductDetails extends HttpServlet {

    IProductDao productDao = new IProductDaoImpl();
    IUserDao userDao = new IUserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);
        request.setAttribute("product", product);

        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("buyer", buyer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/showProductDetails.jsp");
        requestDispatcher.forward(request, response);
    }
}
