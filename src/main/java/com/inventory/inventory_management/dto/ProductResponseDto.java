package com.inventory.inventory_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponseDto {

    private Long id;
    private String name;
    private String sku;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Integer reorderLevel;
    private Long categoryId;
    private String categoryName;
    private Long supplierId;
    private String supplierName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}