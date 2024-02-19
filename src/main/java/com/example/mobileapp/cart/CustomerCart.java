package com.example.mobileapp.cart;

public class CustomerCart {

    private Integer customerId;
    private Integer productId;
    public CustomerCart() {
        super();
    }
    public CustomerCart(Integer customerId, Integer productId) {
        super();
        this.customerId = customerId;
        this.productId = productId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

}
