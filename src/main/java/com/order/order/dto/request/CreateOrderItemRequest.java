package com.order.order.dto.request;

import java.util.UUID;

public record CreateOrderItemRequest(
        UUID productId,
        Integer quantity
) {
}
