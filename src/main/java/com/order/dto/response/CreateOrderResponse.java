package com.order.dto.response;

import com.order.domain.OrderStatus;

import java.math.BigDecimal;

public record CreateOrderResponse(String OrderId,
                                  BigDecimal totalPrice,
                                  OrderStatus status) {
}
