package controller;

import dao.IProductDao;
import dao.IPurchaseDao;
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

@WebServlet(name = "CreateBuyer", urlPatterns = "/create-buyer")
public class CreateBuyer extends HttpServlet {

    IUserDao userDao = new IUserDaoImpl();
IProductDao productDao = new IProductDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPass");
        String userRole = "buyer";
        String phoneNumber = request.getParameter("phoneNumber");
        String userName = request.getParameter("userName");
        User buyer = new User(userEmail, userPass, userRole, phoneNumber, userName);
        userDao.saveBuyer(buyer);

        String buyerEmail = buyer.getUserEmail();
        User newUser = userDao.findBuyerByEmail(buyerEmail);
        List<Product> products = productDao.listAllProduct();


        request.setAttribute("products",products);

        request.setAttribute("buyer", newUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/buyerPage.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
