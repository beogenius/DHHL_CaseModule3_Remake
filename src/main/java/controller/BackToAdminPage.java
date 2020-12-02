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

@WebServlet(name = "BackToAdminPage", urlPatterns = "/back-to-admin-page")
public class BackToAdminPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserDao IUserDao = new IUserDaoImpl();
        IShopDao IShopDao = new IShopDaoImpl();
        List<User> buyerLimitList = IUserDao.listBuyerLimit10();
        request.setAttribute("buyerLimitList", buyerLimitList);
        List<Shop> shopLimitList = IShopDao.listShopLimit10();
        request.setAttribute("shopLimitList", shopLimitList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/adminPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
