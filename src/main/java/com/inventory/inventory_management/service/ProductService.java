package com.inventory.inventory_management.service;

import com.inventory.inventory_management.dto.ProductRequestDto;
import com.inventory.inventory_management.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto requestDto);

    ProductResponseDto getById(Long id);

    List<ProductResponseDto> getAll();

    ProductResponseDto update(Long id, ProductRequestDto requestDto);

    void delete(Long id);
}