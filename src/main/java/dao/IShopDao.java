package dao;

import model.Product;
import model.Shop;

import java.util.List;

public interface IShopDao {

    List<Shop> listShop();

    List<Shop> listShopLimit10();

    List<Product> listShopProduct(int shopID);

    Shop findShopById(int shopID);

    void updateProduct(Product updatedProduct);

    void stopSellProduct(Product product);

    void saveProduct(Product product);

    List<Product> list8Products(int shopID);

    void CreateShop(Shop shop);

    Shop findShopByEmail(String shopEmail);
    public void deleteShop(int id);
}
