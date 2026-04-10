package com.order.customer.entity;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String cpf;
    private Address address;
    private String phone;

    public Customer() {}

    public Customer(UUID id, String name, String cpf, Address address, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
