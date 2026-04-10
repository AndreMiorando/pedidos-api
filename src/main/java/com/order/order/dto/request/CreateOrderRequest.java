package com.order.order.dto.request;

import java.util.List;
import java.util.UUID;

public record CreateOrderRequest(
        UUID customerId,
        List<CreateOrderItemRequest> items
) {
}

