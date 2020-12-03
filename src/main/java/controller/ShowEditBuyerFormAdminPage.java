package controller;

import dao.IUserDao;
import dao.impl.IUserDaoImpl;
import model.Product;
import model.Shop;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEditBuyerFormAdminPage", urlPatterns = "/show-edit-buyer-form")
public class ShowEditBuyerFormAdminPage extends HttpServlet {
    IUserDao userDao = new IUserDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int buyerID = Integer.parseInt(request.getParameter("Buyerid"));

        String name = request.getParameter("buyerName");
        String email = request.getParameter("buyerEmail");
        String pw = request.getParameter("buyerPassword");
        String phone = request.getParameter("buyerPhoneNumber");
        String role = request.getParameter("buyerRole");
        User updatedUser = new User(buyerID,email,pw,role,phone,name);
        userDao.updateUser(updatedUser);
        request.setAttribute("updatedUser", updatedUser);
        request.setAttribute("message", "Product was updated successfully");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/showEditBuyerForm.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int buyerID = Integer.parseInt(request.getParameter("Buyerid"));
        User buyer = userDao.findBuyerById(buyerID);
        request.setAttribute("buyer", buyer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/showEditBuyerForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
