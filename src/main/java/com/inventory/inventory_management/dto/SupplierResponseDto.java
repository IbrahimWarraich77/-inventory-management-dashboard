package com.inventory.inventory_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SupplierResponseDto {

    private Long id;
    private String name;
    private String contactPerson;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}