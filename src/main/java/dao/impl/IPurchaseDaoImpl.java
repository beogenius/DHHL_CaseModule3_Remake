package dao.impl;

import dao.IPurchaseDao;
import jdbc.JDBCConnection;
import model.Product;
import model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IPurchaseDaoImpl implements IPurchaseDao {
    Connection connection = JDBCConnection.getConnection();
    private static final String ADD_PURCHASE =
            "insert into purchase(productId, userId, date, purchaseQuantity) VALUE (?,?,?,?)";

    private static final String SELECT_ALL_PURCHASE_OF_BUYER =
            "select * from purchase left join products p on p.productID = purchase.productId where userId = ?";

    private static final String LIST_SHOP_PURCHASE_BY_TIME =
            "select * from purchase join products p on p.productID = purchase.productId where shopID = ? and date >= ? and date < ?";


    private static final String LIST_SHOP_PURCHASE =
            "select * from purchase join products p on p.productID = purchase.productId where shopID = ?";

    @Override
    public void addPurchase(Purchase purchase) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PURCHASE);
            preparedStatement.setInt(1, purchase.getProductID());
            preparedStatement.setInt(2, purchase.getUserId());
            Date date = purchase.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = sdf.format(date);
            Date parsed = null;
            try {
                parsed = sdf.parse(formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            preparedStatement.setDate(3, sql);
            preparedStatement.setInt(4, purchase.getPurchaseQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Purchase> listAllPurchaseOfBuyer(int buyerID) {
        List<Purchase> purchases = null;
        try {
            purchases = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PURCHASE_OF_BUYER);
            ps.setInt(1, buyerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int purchaseID = rs.getInt("purchaseId");
                int productID = rs.getInt("purchase.productId");
                int shopID = rs.getInt("shopID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int userID = rs.getInt("userId");
                Date date = rs.getDate("date");
                int purchaseQuantity = rs.getInt("purchaseQuantity");

                Purchase purchase = new Purchase(purchaseID, productID, shopID, productName, productImage, productPrice,
                        productDescription, shopName, userID, date, purchaseQuantity);
                purchases.add(purchase);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return purchases;
    }

    @Override
    public List<Purchase> listShopPurchaseByTime(int shopID, String startDateStr, String endDateStr) {
        List<Purchase> purchases = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = sdf.parse(startDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = null;
        try {
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            purchases = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(LIST_SHOP_PURCHASE_BY_TIME);
            ps.setInt(1, shopID);
            String formatStartDate = sdf.format(startDate);
            Date parseStart = sdf.parse(formatStartDate);
            java.sql.Date sqlStartDate = new java.sql.Date(parseStart.getTime());
            ps.setDate(2, sqlStartDate);

            String formatEndDate = sdf.format(endDate);
            Date parseEnd = sdf.parse(formatEndDate);
            java.sql.Date sqlEndDate = new java.sql.Date(parseEnd.getTime());
            ps.setDate(3, sqlEndDate);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int purchaseID = rs.getInt("purchaseId");
                int productID = rs.getInt("p.productID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                Double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int userId = rs.getInt("userId");
                Date date = rs.getDate("date");
                int purchaseQuantity = rs.getInt("purchaseQuantity");
                Purchase purchase = new Purchase(productID, shopID, productName, productImage, productPrice, productDescription,
                        shopName, userId, date, purchaseQuantity);
                purchases.add(purchase);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return purchases;
    }

    @Override
    public List<Purchase> listShopPurchase(int shopID) {
        List<Purchase> shopPurchases = null;
        try {
            shopPurchases = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(LIST_SHOP_PURCHASE);
            ps.setInt(1, shopID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int purchaseID = rs.getInt("purchaseId");
                int productID = rs.getInt("p.productID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                Double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int userId = rs.getInt("userId");
                Date date = rs.getDate("date");
                int purchaseQuantity = rs.getInt("purchaseQuantity");
                Purchase purchase = new Purchase(productID, shopID, productName, productImage, productPrice, productDescription,
                        shopName, userId, date, purchaseQuantity);
                shopPurchases.add(purchase);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopPurchases;
    }
}

