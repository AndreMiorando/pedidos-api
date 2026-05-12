package com.order.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private BigDecimal totalPrice;
    private OrderStatus status;

    public Order() {}

    public Order(String id, Customer customer, List<OrderItem> items, BigDecimal totalPrice, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}