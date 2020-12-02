package controller;

import dao.IPurchaseDao;
import dao.IShopDao;
import dao.impl.IPurchaseDaoImpl;
import dao.impl.IShopDaoImpl;
import model.Purchase;
import model.Shop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowRevenueForm", urlPatterns = "/show-revenue-form")
public class ShowRevenueForm extends HttpServlet {
    IShopDao shopDao = new IShopDaoImpl();
    IPurchaseDao purchaseDao = new IPurchaseDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        List<Purchase> purchases = purchaseDao.listShopPurchaseByTime(shopID, startDateStr, endDateStr);
        request.setAttribute("purchases", purchases);
        request.setAttribute("shop", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showShopRevenue.jsp");
        requestDispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        List<Purchase> shopPurchases = purchaseDao.listShopPurchase(shopID);
        request.setAttribute("shopPurchases", shopPurchases);
        request.setAttribute("shop", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showRevenueForm.jsp");
        requestDispatcher.forward(request,response);
    }
}
