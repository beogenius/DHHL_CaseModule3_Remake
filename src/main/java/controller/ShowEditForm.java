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

@WebServlet(name = "ShowEditForm", urlPatterns = "/show-edit-form")
public class ShowEditForm extends HttpServlet {
    IProductDao productDao = new IProductDaoImpl();
    IShopDao shopDao = new IShopDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);

        int shopID = product.getShopID();
        Shop shop = shopDao.findShopById(shopID);

        String productName = request.getParameter("productName");
        String productImage = product.getProductImage();
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        String shopName = product.getShopName();
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        Product updatedProduct = new Product(productID,shopID,productName,productImage,productPrice,productDescription,
                shopName,productQuantity);
        shopDao.updateProduct(updatedProduct);
        request.setAttribute("shop", shop);
        request.setAttribute("product", updatedProduct);
        request.setAttribute("message", "Product was updated successfully");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showEditForm.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);
        int shopID = Integer.parseInt(request.getParameter("shopid"));
        Shop shop = shopDao.findShopById(shopID);
        request.setAttribute("product", product);
        request.setAttribute("shop", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shop/showEditForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
