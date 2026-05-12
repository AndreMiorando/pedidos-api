package com.order.domain;

import java.math.BigDecimal;

public class OrderItem {
    private String id;
    private String name;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Integer quantity;

    public OrderItem() {}

    public OrderItem(String id, String name, BigDecimal price, BigDecimal totalPrice, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
