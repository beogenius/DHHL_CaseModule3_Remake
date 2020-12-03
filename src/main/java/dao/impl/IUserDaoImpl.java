package dao.impl;

import dao.IUserDao;
import jdbc.JDBCConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    Connection connection = JDBCConnection.getConnection();
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_ALL_BUYERS = "select * from users where userRole = 'buyer'";
    private static final String SELECT_ALL_BUYERS_LIMIT_10 = "select * from users where userRole = 'buyer' limit 10";
    private static final String FIND_BUYER_BY_ID = "select * from users where userRole = 'buyer' and userID = ?";
    private static final String CREATE_ACCOUNT = "INSERT INTO users ( userEmail, userPass, userRole, phoneNumber,userName) VALUE (?,?,?,?,?)";
    private static final String FIND_BUYER_BY_EMAIL = "select * from users where userRole = 'buyer' and userEmail = ?";
    String deleteUserSql = "delete from users where userId=?;";

    private static final String UPDATE_USER = "update users set userName = ?, userEmail = ?, userPass = ?, phoneNumber = ?, userRole=? where userId = ?";
    @Override
    public List<User> listUser() {
        List<User> users = null;

        try {
            users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userEmail = rs.getString("userEmail");
                String userPass = rs.getString("userPass");
                String userRole = rs.getString("userRole");
                String phoneNumber = rs.getString("phoneNumber");
                String userName = rs.getString("userName");
                User user = new User(userID, userEmail, userPass, userRole, phoneNumber, userName);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> listBuyer() {
        List<User> buyers = null;
        try {
            buyers = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUYERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userEmail = rs.getString("userEmail");
                String userPass = rs.getString("userPass");
                String userRole = rs.getString("userRole");
                String phoneNumber = rs.getString("phoneNumber");
                String userName = rs.getString("userName");
                User buyer = new User(userID, userEmail, userPass, userRole, phoneNumber, userName);
                buyers.add(buyer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyers;
    }

    @Override
    public List<User> listBuyerLimit10() {
        List<User> buyerLimitList = null;
        try {
            buyerLimitList = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUYERS_LIMIT_10);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userEmail = rs.getString("userEmail");
                String userPass = rs.getString("userPass");
                String userRole = rs.getString("userRole");
                String phoneNumber = rs.getString("phoneNumber");
                String userName = rs.getString("userName");
                User buyer = new User(userID, userEmail, userPass, userRole, phoneNumber, userName);
                buyerLimitList.add(buyer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerLimitList;
    }

    @Override
    public User findBuyerById(int buyerID) {
        User buyer = null;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BUYER_BY_ID);
            ps.setInt(1, buyerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userEmail = rs.getString("userEmail");
                String userPass = rs.getString("userPass");
                String userRole = rs.getString("userRole");
                String phoneNumber = rs.getString("phoneNumber");
                String userName = rs.getString("userName");
                buyer = new User(buyerID, userEmail, userPass, userRole, phoneNumber, userName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buyer;
    }

    @Override
    public void saveBuyer(User buyer) {
        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_ACCOUNT);
            ps.setString(1, buyer.getUserEmail());
            ps.setString(2, buyer.getUserPass());
            ps.setString(3, buyer.getUserRole());
            ps.setString(4, buyer.getPhoneNumber());
            ps.setString(5, buyer.getUserName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User findBuyerByEmail(String buyerEmail) {
        User buyer = null;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BUYER_BY_EMAIL);
            ps.setString(1, buyerEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userId");
                String userPass = rs.getString("userPass");
                String userRole = rs.getString("userRole");
                String phoneNumber = rs.getString("phoneNumber");
                String userName = rs.getString("userName");
                buyer = new User(userID, buyerEmail, userPass, userRole, phoneNumber, userName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buyer;
    }

    @Override
    public void updateUser(User updatedUser) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER);
            ps.setString(1, updatedUser.getUserName());
            ps.setString(2, updatedUser.getUserEmail());
            ps.setString(3, updatedUser.getUserPass());
            ps.setString(4, updatedUser.getPhoneNumber());
            ps.setString(5, updatedUser.getUserRole());
            ps.setInt(6,updatedUser.getUserID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id){
        try {
            PreparedStatement psUser = connection.prepareStatement(deleteUserSql);
            psUser.setInt(1,id);
            psUser.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
