package controller;

import dao.IShopDao;
import dao.IUserDao;
import dao.impl.IShopDaoImpl;
import dao.impl.IUserDaoImpl;
import model.Shop;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowBuyerList", urlPatterns = "/show-buyer-list")
public class ShowBuyerList extends HttpServlet {
    IUserDao IUserDao = new IUserDaoImpl();
    IShopDao IShopDao = new IShopDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> buyers = IUserDao.listBuyer();
        request.setAttribute("buyers", buyers);
        List<User> buyer = IUserDao.listBuyer();
        request.setAttribute("buyers", buyer);
        List<Shop> shop = IShopDao.listShop();
        request.setAttribute("shops", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/showBuyerList.jsp");
        requestDispatcher.forward(request, response);
    }
}
