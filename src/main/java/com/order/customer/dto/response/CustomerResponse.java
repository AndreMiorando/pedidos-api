package com.order.customer.dto.response;

public record CustomerResponse(
        String id,
        String name,
        String cpf,
        CustomerAddressResponse address,
        String phone
) {
}
