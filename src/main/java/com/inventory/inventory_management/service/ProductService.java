package com.inventory.inventory_management.service;

import com.inventory.inventory_management.dto.ProductRequestDto;
import com.inventory.inventory_management.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto requestDto);

    ProductResponseDto getById(Long id);
}