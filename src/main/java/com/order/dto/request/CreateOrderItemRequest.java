package com.order.dto.request;

public record CreateOrderItemRequest(String itemId,
                                     Integer quantity) {
}
