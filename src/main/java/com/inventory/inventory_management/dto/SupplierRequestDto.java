package com.inventory.inventory_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequestDto {

    @NotBlank(message = "Supplier name is required")
    private String name;

    private String contactPerson;

    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    private String address;
}
