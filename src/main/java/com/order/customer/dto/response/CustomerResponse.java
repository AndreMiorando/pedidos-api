package com.order.customer.dto.response;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String name,
        String cpf,
        CustomerAddressResponse address,
        String phone
) {
}
