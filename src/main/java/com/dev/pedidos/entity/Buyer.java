package com.dev.pedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Buyer {

    @Id
    private String id;
    private String cpf;
    private String name;
    private String percentageDiscount;

    public Buyer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
}
