package dao.impl;

import dao.IProductDao;
import jdbc.JDBCConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProductDaoImpl implements IProductDao {
    Connection connection = JDBCConnection.getConnection();
    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String FIND_PRODUCTS_BY_NAME = "select * from products where productName like ?";
    private static final String FIND_PRODUCTS_BY_PRICE = "select * from products where productPrice > ? and productPrice <= ?";
    private static final String FIND_PRODUCT_BY_ID = "select * from products where productID = ?";
    private static final String UPDATE_PRODUCT_QUANTITY = "update products set productQuantity = ? where productID = ?";

    @Override
    public List<Product> listAllProduct() {
        List<Product> products = null;

        try {
            products = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                int shopID = rs.getInt("shopID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                Double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                String shopName = rs.getString("shopName");
                int productQuantity = rs.getInt("productQuantity");
                Product product = new Product(productID, shopID, productName, productImage, productPrice,
                        productDescription, shopName, productQuantity);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findProductById(int productID) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            statement.setInt(1, productID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int shopID = resultSet.getInt(2);
                String productName = resultSet.getString(3);
                String productImage = resultSet.getString(4);
                double productPrice = resultSet.getDouble(5);
                String productDescription = resultSet.getString(6);
                String shopName = resultSet.getString(7);
                int productQuantity = resultSet.getInt(8);
                product = new Product(productID, shopID, productName, productImage, productPrice, productDescription,
                        shopName, productQuantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductsByName(String _productName) {
        List<Product> products = null;
        try {
            products = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, "%" + _productName + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                int shopID = rs.getInt(2);
                String productName = rs.getString(3);
                String productImage = rs.getString(4);
                Double productPrice = rs.getDouble(5);
                String productDescription = rs.getString(6);
                String shopName = rs.getString(7);
                int productQuantity = rs.getInt(8);
                Product product = new Product(productID, shopID, productName, productImage, productPrice,
                        productDescription, shopName, productQuantity);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findProductsByPrice(double firstPrice, double secondPrice) {
        List<Product> products = null;
        try {
            products = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(FIND_PRODUCTS_BY_PRICE);
            ps.setDouble(1, firstPrice);
            ps.setDouble(2, secondPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt(1);
                int shopID = rs.getInt(2);
                String productName = rs.getString(3);
                String productImage = rs.getString(4);
                Double productPrice = rs.getDouble(5);
                String productDescription = rs.getString(6);
                String shopName = rs.getString(7);
                int productQuantity = rs.getInt(8);
                Product product = new Product(productId, shopID, productName, productImage, productPrice, productDescription,
                        shopName, productQuantity);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;

    }

    @Override
    public void updateProductQuantity(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_QUANTITY);
            ps.setInt(1, product.getProductQuantity());
            ps.setInt(2, product.getProductID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
