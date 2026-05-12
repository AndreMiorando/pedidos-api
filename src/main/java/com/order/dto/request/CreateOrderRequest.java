package com.order.dto.request;

import java.util.List;

public record CreateOrderRequest(String customerId,
                                 List<CreateOrderItemRequest> items
                                 ) {
}
