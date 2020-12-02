package model;

public class Product {
    private int productID;
    private int shopID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
    private String shopName;
    private int productQuantity;

    public Product() {
    }

    public Product(int productID, int shopID, String productName, String productImage, double productPrice,
                   String productDescription, String shopName, int productQuantity) {
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shopName = shopName;
        this.productQuantity = productQuantity;
    }

    public Product(int shopID, String productName, String productImage, double productPrice, String productDescription, String shopName, int productQuantity) {
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shopName = shopName;
        this.productQuantity = productQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
