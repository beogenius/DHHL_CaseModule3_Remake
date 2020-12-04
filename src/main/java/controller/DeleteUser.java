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

@WebServlet(name = "DeleteUser", urlPatterns = "/customersUser")
public class DeleteUser extends HttpServlet {
    private IUserDao userDelete = new IUserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        delete(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userDelete.deleteUser(id);

        IUserDao IUserDao = new IUserDaoImpl();
        IShopDao IShopDao = new IShopDaoImpl();
        List<User> buyer = IUserDao.listBuyer();
        request.setAttribute("buyers", buyer);
        List<Shop> shop = IShopDao.listShop();
        request.setAttribute("shops", shop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/adminPage.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}
