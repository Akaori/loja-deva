package com.tech.ada.java.lojadeva.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;

    @OneToMany
    private List<Product> products;

    private BigDecimal total;

    private String paymentMethod;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Order() {
        this.status = "Pending";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Order(Long clientId,
                 List<Product> products,
                 BigDecimal total,
                 String paymentMethod) {
        this.clientId = clientId;
        this.products = products;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}