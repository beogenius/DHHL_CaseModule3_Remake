package controller;

import dao.IPurchaseDao;
import dao.IUserDao;
import dao.impl.IPurchaseDaoImpl;
import dao.impl.IUserDaoImpl;
import model.Purchase;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowPurchaseHistory", urlPatterns = "/show-purchase-history")
public class ShowPurchaseHistory extends HttpServlet {

    IPurchaseDao purchaseDao = new IPurchaseDaoImpl();
    IUserDao userDao = new IUserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        List<Purchase> purchases = purchaseDao.listAllPurchaseOfBuyer(buyerID);
        request.setAttribute("buyer", buyer);
        request.setAttribute("purchases", purchases);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/showPurchaseHistory.jsp");
        requestDispatcher.forward(request, response);
    }
}
