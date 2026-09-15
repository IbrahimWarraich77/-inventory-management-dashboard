package com.inventory.inventory_management.entity;

import com.inventory.inventory_management.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_transaction")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private Integer quantity;

    private String reason;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}