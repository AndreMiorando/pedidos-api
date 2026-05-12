package com.order.controller;

import com.order.application.OrderService;


public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



}
