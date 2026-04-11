package com.order.customer.application;

import com.order.customer.dto.request.CreateCustomerAddressRequest;
import com.order.customer.dto.request.CreateCustomerRequest;
import com.order.customer.dto.response.CustomerAddressResponse;
import com.order.customer.dto.response.CustomerResponse;
import com.order.customer.entity.Address;
import com.order.customer.entity.Customer;
import com.order.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        validateCreateRequest(request);
        String normalizedCpf = normalizeAndValidateCpf(request.cpf());
        String normalizedCep = normalizeAndValidateCep(request.address().cep());
        String normalizedPhone = normalizeAndValidatePhone(request.phone());

        Address address = new Address(
                request.address().street(),
                request.address().number(),
                request.address().complement(),
                request.address().city(),
                request.address().state(),
                normalizedCep
        );

        Customer customer = new Customer(
                request.name(),
                normalizedCpf,
                address,
                normalizedPhone
        );

        Customer savedCustomer = repository.save(customer);

        return toResponse(savedCustomer);
    }

    private void validateCreateRequest(CreateCustomerRequest request) {
        if (request == null) {
            throw new RuntimeException("Request não pode ser nulo");
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (request.cpf() == null || request.cpf().isBlank()) {
            throw new RuntimeException("CPF é obrigatório");
        }

        validateCreateAddressRequest(request.address());

        if (request.phone() == null || request.phone().isBlank()) {
            throw new RuntimeException("Telefone é obrigatório");
        }
    }

    private void validateCreateAddressRequest(CreateCustomerAddressRequest request) {
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

    private String normalizeAndValidateCpf(String cpf) {
        String normalized = cpf.replaceAll("[^0-9]", "");

        if (normalized.length() != 11) {
            throw new RuntimeException("CPF deve ter 11 digitos");
        }

        if (repository.existsByCpf(normalized)) {
            throw new RuntimeException("CPF já cadastrado");
        }

        return normalized;
    }

    private String normalizeAndValidateCep(String cep){
        String normalized = cep.replaceAll("[^0-9]", "");

        if (normalized.length() != 8) {
            throw new RuntimeException("CEP deve ter 8 digitos");
        }

        return normalized;
    }

    private String normalizeAndValidatePhone(String phone) {
        String normalized = phone.replaceAll("[^0-9]", "");

        if (normalized.length() != 11) {
            throw new RuntimeException("Telefone deve ter 11 digitos");
        }

        return normalized;
    }

    private CustomerResponse toResponse(Customer customer) {

        CustomerAddressResponse addressResponse = new CustomerAddressResponse(
                customer.getAddress().getStreet(),
                customer.getAddress().getNumber(),
                customer.getAddress().getComplement(),
                customer.getAddress().getCity(),
                customer.getAddress().getState(),
                customer.getAddress().getCep()
        );

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                addressResponse,
                customer.getPhone()
        );
    }
}
