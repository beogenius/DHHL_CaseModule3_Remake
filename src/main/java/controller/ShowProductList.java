package controller;

import dao.IShopDao;
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

@WebServlet(name = "ShowProductList", urlPatterns = "/show-product-list")
public class ShowProductList extends HttpServlet {
    IShopDao shopDao = new IShopDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        List<Product> shopProducts = shopDao.listShopProduct(shopID);
        request.setAttribute("shop", shop);
        request.setAttribute("shopProducts", shopProducts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showProductList.jsp");
        requestDispatcher.forward(request, response);
    }
}
