package model;

import java.util.Date;

public class Purchase {
    private  int purchaseID;
    private int productID;
    private int shopID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
    private String shopName;
    private  int userId;
    private Date date;
    private int purchaseQuantity;

    public Purchase() {
    }

    public Purchase(int productID, int shopID, String productName, String productImage, double productPrice,
                    String productDescription, String shopName, int userId, Date date, int purchaseQuantity) {
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shopName = shopName;
        this.userId = userId;
        this.date = date;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Purchase(int purchaseID, int productID, int shopID, String productName, String productImage, double productPrice, String productDescription, String shopName, int userId, Date date, int purchaseQuantity) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shopName = shopName;
        this.userId = userId;
        this.date = date;
        this.purchaseQuantity = purchaseQuantity;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}

