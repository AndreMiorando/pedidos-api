package com.order.order.entity;

import com.order.customer.entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private List<OrderItem> items;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal total;
    private OrderStatus status;

    public Order(UUID id, Customer customer, List<OrderItem> items, BigDecimal subtotal, BigDecimal discount, BigDecimal total, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.subtotal = subtotal;
        this.discount = discount;
        this.total = total;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
