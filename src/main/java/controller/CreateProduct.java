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

@WebServlet(name = "CreateProduct", urlPatterns = "/create-product")
public class CreateProduct extends HttpServlet {
    IShopDao shopDao = new IShopDaoImpl();
//
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        request.setAttribute("shop", shop);
        String productName = request.getParameter("productName");
        String productImage = request.getParameter("productImage");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        String shopName = shop.getShopName();

        Product product = new Product(shopID,productName,productImage,productPrice,productDescription,shopName,
                productQuantity);

        shopDao.saveProduct(product);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showProductDetailsShop.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        request.setAttribute("shop", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/createProduct.jsp");
        requestDispatcher.forward(request, response);
    }
}
