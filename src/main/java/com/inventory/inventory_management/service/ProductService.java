package com.inventory.inventory_management.service;

import com.inventory.inventory_management.dto.ProductRequestDto;
import com.inventory.inventory_management.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto requestDto);

    ProductResponseDto getById(Long id);

    Page<ProductResponseDto> getAll(String name, Pageable pageable);

    ProductResponseDto update(Long id, ProductRequestDto requestDto);

    void delete(Long id);
}