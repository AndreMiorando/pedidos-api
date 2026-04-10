package com.order.customer.application;

import com.order.customer.dto.request.CreateCustomerAddressRequest;
import com.order.customer.dto.request.CreateCustomerRequest;
import com.order.customer.dto.response.CustomerAddressResponse;
import com.order.customer.dto.response.CustomerResponse;
import com.order.customer.entity.Address;
import com.order.customer.entity.Customer;
import com.order.customer.repository.CustomerRepository;

import java.util.UUID;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        validateRequest(request);
        String normalizedCpf = normalizeCpf(request.cpf());
        validateCpfLength(normalizedCpf);
        String normalizedCep = normalizeCep(request.address().cep());
        validateCepLength(normalizedCep);
        String normalizedPhone = normalizePhone(request.phone());
        validatePhoneLength(normalizedPhone);

        Address address = new Address(
                request.address().street(),
                request.address().number(),
                request.address().complement(),
                request.address().city(),
                request.address().state(),
                normalizedCep
        );

        UUID id = UUID.randomUUID();
        Customer customer = new Customer(
                id,
                request.name(),
                normalizedCpf,
                address,
                normalizedPhone
        );

        Customer savedCustomer = repository.save(customer);

        CustomerAddressResponse addressResponse = new CustomerAddressResponse(
                savedCustomer.getAddress().getStreet(),
                savedCustomer.getAddress().getNumber(),
                savedCustomer.getAddress().getComplement(),
                savedCustomer.getAddress().getCity(),
                savedCustomer.getAddress().getState(),
                savedCustomer.getAddress().getCep()
        );

        return new CustomerResponse(
                savedCustomer.getId(),
                savedCustomer.getName(),
                savedCustomer.getCpf(),
                addressResponse,
                savedCustomer.getPhone()
        );
    }



    private void validateRequest(CreateCustomerRequest request) {
        if (request == null) {
            throw new RuntimeException("Request não pode ser nulo");
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (request.cpf() == null || request.cpf().isBlank()) {
            throw new RuntimeException("CPF é obrigatório");
        }

        validateAddressRequest(request.address());

        if (request.phone() == null || request.phone().isBlank()) {
            throw new RuntimeException("Telefone é obrigatório");
        }
    }

    private void validateAddressRequest(CreateCustomerAddressRequest request) {
        if (request == null) {
            throw new RuntimeException("Endereço é obrigatório");
        }

        if (request.street() == null || request.street().isBlank()) {
            throw new RuntimeException("Rua é obrigatória");
        }

        if (request.number() == null || request.number().isBlank()) {
            throw new RuntimeException("Numero é obrigatório");
        }

        if (request.city() == null || request.city().isBlank()) {
            throw new RuntimeException("Cidade é obrigatória");
        }

        if (request.state() == null || request.state().isBlank()) {
            throw new RuntimeException("Estado é obrigatório");
        }

        if (request.cep() == null || request.cep().isBlank()) {
            throw new RuntimeException("CEP é obrigatório");
        }
    }

    private String normalizeCpf(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    private String normalizeCep(String cep) {
        return cep.replaceAll("[^0-9]", "");
    }

    private String normalizePhone(String phone) {
        return phone.replaceAll("[^0-9]", "");
    }

    private void validateCpfLength(String cpf) {
        if (cpf.length() != 11) {
            throw new RuntimeException("CPF deve ter 11 digitos");
        }
    }

    private void validateCepLength(String cep) {
        if (cep.length() != 8) {
            throw new RuntimeException("CEP deve ter 8 digitos");
        }
    }

    private void validatePhoneLength(String phone) {
        if (phone.length() != 11) {
            throw new RuntimeException("Telefone deve ter 11 digitos");
        }
    }

}
