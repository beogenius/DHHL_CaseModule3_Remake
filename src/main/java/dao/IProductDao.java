package dao;

import model.Product;
import model.User;

import java.util.List;

public interface IProductDao {
    List<Product> listAllProduct();

    Product findProductById(int id);

    List<Product> findProductsByName(String productName);

    List<Product> findProductsByPrice(double firstPrice, double secondPrice);

    void updateProductQuantity(Product product);

    List<Product> listTopProduct();
}
