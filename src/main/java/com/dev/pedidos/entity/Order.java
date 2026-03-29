package com.dev.pedidos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {

    @Id
    private String id;
    @OneToMany
    private List<OrderItem> itens;
    @ManyToOne
    private Buyer buyer;

    public Order() {
    }

    public Order(String id, List<OrderItem> itens, Buyer buyer) {
        this.id = id;
        this.itens = itens;
        this.buyer = buyer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public void setItens(List<OrderItem> itens) {
        this.itens = itens;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
