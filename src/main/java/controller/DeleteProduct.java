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

@WebServlet(name = "DeleteProduct", urlPatterns = "/delete-product")
public class DeleteProduct extends HttpServlet {
    IProductDao productDao = new IProductDaoImpl();
    IShopDao shopDao = new IShopDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);
        shopDao.stopSellProduct(product);

        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);

        request.setAttribute("message","Product was stopped from selling!");
        request.setAttribute("shop", shop);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showDeleteForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
