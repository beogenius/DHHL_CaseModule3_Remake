package controller;

import dao.IProductDao;
import dao.IShopDao;
import dao.impl.IProductDaoImpl;
import dao.impl.IShopDaoImpl;
import model.Product;
import model.Shop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateShop", urlPatterns = "/create-shop")
public class CreateShop extends HttpServlet {
IProductDao productDao = new IProductDaoImpl();
    IShopDao shopDao = new IShopDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopName = request.getParameter("shopName");
        String shopEmail = request.getParameter("shopEmail");
        String shopPass = request.getParameter("shopPass");
        String address = request.getParameter("address");
        Shop shop= new Shop(shopName,shopEmail,shopPass,address);
        shopDao.CreateShop(shop);

        Shop newShop = shopDao.findShopByEmail(shopEmail);
        List<Product> shopProducts = shopDao.listShopProduct(newShop.getShopID());
        request.setAttribute("shopProducts", shopProducts);
        request.setAttribute("shop", newShop);


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/shop/shopPage.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
