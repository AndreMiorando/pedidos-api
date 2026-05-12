package com.order.dto.request;

public record CreateOrderItemRequest(String orderId,
                                     Integer quantity) {
}
