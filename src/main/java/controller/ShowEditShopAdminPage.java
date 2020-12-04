package controller;

import dao.IShopDao;
import dao.impl.IShopDaoImpl;
import model.Shop;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEditShopAdminPage", urlPatterns = "/show-edit-shop-form")
public class ShowEditShopAdminPage extends HttpServlet {
    IShopDao shopDao = new IShopDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("ShopID"));

        String name = request.getParameter("shopName");
        String email = request.getParameter("shopEmail");
        String pw = request.getParameter("shopPassword");
        String address = request.getParameter("shopAddress");
        Shop updatedShop = new Shop(shopID,name,email,pw,address);
        shopDao.updateShop(updatedShop);
        request.setAttribute("message", "Product was updated successfully");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/showEditShopForm.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shopID = Integer.parseInt(request.getParameter("ShopID"));
        Shop shop = shopDao.findShopById(shopID);
        request.setAttribute("shop", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/showEditShopForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
