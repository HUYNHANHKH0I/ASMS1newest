package com.project.asms1.model;

public class OrderDetail {
    private String ID, OrderID, ProductID;
    private int Quantity;
    private float Price;

    public OrderDetail(String ID, String orderID, String productID, int quantity, float price) {
        this.ID = ID;
        OrderID = orderID;
        ProductID = productID;
        Quantity = quantity;
        Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
