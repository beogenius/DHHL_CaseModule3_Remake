package controller;

import dao.IProductDao;
import dao.IPurchaseDao;
import dao.IUserDao;
import dao.impl.IProductDaoImpl;
import dao.impl.IPurchaseDaoImpl;
import dao.impl.IUserDaoImpl;
import model.Product;
import model.Purchase;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Buy Product", urlPatterns = "/buy-product")
public class BuyProduct extends HttpServlet {

    IProductDao productDao = new IProductDaoImpl();
    IUserDao userDao = new IUserDaoImpl();
    IPurchaseDao purchaseDao = new IPurchaseDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);
        int purchaseQuantity = Integer.parseInt(request.getParameter("quantity"));
        int shopID = product.getShopID();
        String productName = product.getProductName();
        String productImage = product.getProductImage();
        Double productPrice = product.getProductPrice();
        String productDescription = product.getProductDescription();
        String shopName = product.getShopName();
        int leftQuantity = product.getProductQuantity() - purchaseQuantity;
        Product updatedProduct = new Product(productID,shopID,productName,productImage,productPrice,productDescription,
                shopName,leftQuantity);
        productDao.updateProductQuantity(updatedProduct);
        request.setAttribute("product", updatedProduct);
        request.setAttribute("message", "You bought this product successfully!");


        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        String purchaseDate = request.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(purchaseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Purchase purchase = new Purchase(productID, shopID, productName, productImage, productPrice, productDescription,
                shopName, buyerID, date, purchaseQuantity);
        purchaseDao.addPurchase(purchase);
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("buyer", buyer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/showBuyForm.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = productDao.findProductById(productID);
        int buyerID = Integer.parseInt(request.getParameter("buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("product", product);
        request.setAttribute("buyer", buyer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/buyer/showBuyForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
