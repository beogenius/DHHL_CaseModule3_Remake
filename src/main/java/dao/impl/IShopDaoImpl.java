package dao.impl;

import dao.IShopDao;
import jdbc.JDBCConnection;
import model.Product;
import model.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IShopDaoImpl implements IShopDao {
    Connection connection = JDBCConnection.getConnection();
    private static final String SELECT_ALL_SHOPS = "select * from shop";
    private static final String SELECT_ALL_SHOP_PRODUCTS =
            "select * from products join shop s on s.shopID = products.shopID where s.shopID = ?";
    private static final String FIND_SHOP_BY_ID = "select * from shop where shopID = ?";
    private static final String UPDATE_PRODUCT = "update products set productName = ?, productPrice = ?, productDescription = ?, productQuantity = ? where productID = ?";

    private static final String STOP_SELL_PRODUCT = "update products set productQuantity = 0 where productID = ?";

    private static final String INSERT_PRODUCT =
            "insert into products (shopID, productName, productImage, productPrice, productDescription, shopName, productQuantity) value (?,?,?,?,?,?,?) ";

    private static final String SELECT_8_PRODUCTS = "select * from products join shop s on s.shopID = products.shopID where s.shopID = ? limit 8";

    private static final String CREATE_SHOP = "insert into shop(shopName,shopEmail,shopPass,address) values(?,?,?,?)";

    private static final String FIND_SHOP_BY_EMAIL = "select * from shop where shopEmail = ?";

    private static final String UPDATE_SHOP = "update shop set shopName = ?, shopEmail = ?, shopPass = ?, address = ? where shopID = ?";
    String deleteShopSql = "delete from shop where shopID=?;";

    @Override
    public List<Shop> listShop() {
        List<Shop> shops = null;
        try {
            shops = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOPS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int shopID = rs.getInt("shopID");
                String shopName = rs.getString("shopName");

                String shopEmail = rs.getString("shopEmail");
                String shopPass = rs.getString("shopPass");
                String address = rs.getString("address");
                Shop shop = new Shop(shopID, shopName, shopEmail, shopPass, address);
                shops.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    @Override
    public List<Product> listShopProduct(int shopID) {
        List<Product> shopProducts = null;
        try {
            shopProducts = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_SHOP_PRODUCTS);
            ps.setInt(1, shopID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int productQuantity = rs.getInt("productQuantity");
                Product product = new Product(productID, shopID, productName, productImage, productPrice,
                        productDescription, shopName, productQuantity);
                shopProducts.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopProducts;
    }

    @Override
    public Shop findShopById(int shopID) {
        Shop shop = null;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_SHOP_BY_ID);
            ps.setInt(1, shopID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String shopName = rs.getString("shopName");
                String shopEmail = rs.getString("shopEmail");
                String shopPass = rs.getString("shopPass");
                String address = rs.getString("address");
                shop = new Shop(shopID, shopName, shopEmail, shopPass, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, updatedProduct.getProductName());
            ps.setDouble(2, updatedProduct.getProductPrice());
            ps.setString(3, updatedProduct.getProductDescription());
            ps.setInt(4, updatedProduct.getProductQuantity());
            ps.setInt(5, updatedProduct.getProductID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void stopSellProduct(Product product) {
        try {
            int productID = product.getProductID();
            PreparedStatement ps = connection.prepareStatement(STOP_SELL_PRODUCT);
            ps.setInt(1, productID);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveProduct(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT);
            ps.setInt(1, product.getShopID());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductImage());
            ps.setDouble(4, product.getProductPrice());
            ps.setString(5, product.getProductDescription());
            ps.setString(6, product.getShopName());
            ps.setInt(7, product.getProductQuantity());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> list8Products(int shopID) {
        List<Product> shopProducts = null;

        try {
            shopProducts = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SELECT_8_PRODUCTS);
            ps.setInt(1, shopID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int productQuantity = rs.getInt("productQuantity");
                Product product = new Product(productID, shopID, productName, productImage, productPrice,
                        productDescription, shopName, productQuantity);
                shopProducts.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopProducts;
    }

    @Override
    public void CreateShop(Shop shop) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SHOP);
            preparedStatement.setString(1, shop.getShopName());
            preparedStatement.setString(2, shop.getShopEmail());
            preparedStatement.setString(3, shop.getShopPass());
            preparedStatement.setString(4, shop.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Shop findShopByEmail(String shopEmail) {
        Shop shop = null;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_SHOP_BY_EMAIL);
            ps.setString(1, shopEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int shopID = rs.getInt("shopID");
                String shopName = rs.getString("shopName");
                String shopPass = rs.getString("shopPass");
                String address = rs.getString("address");
                shop = new Shop(shopID, shopName, shopEmail, shopPass, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public void deleteShop(int id) {
        try {
            PreparedStatement psShop = connection.prepareStatement(deleteShopSql);
            psShop.setInt(1, id);
            psShop.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateShop(Shop updatedShop) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_SHOP);
            ps.setString(1, updatedShop.getShopName());
            ps.setString(2, updatedShop.getShopEmail());
            ps.setString(3, updatedShop.getShopPass());
            ps.setString(4, updatedShop.getAddress());
            ps.setInt(5, updatedShop.getShopID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
