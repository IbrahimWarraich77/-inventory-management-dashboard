package com.inventory.inventory_management.service;

import com.inventory.inventory_management.dto.CategoryRequestDto;
import com.inventory.inventory_management.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto requestDto);

    CategoryResponseDto getById(Long id);

    List<CategoryResponseDto> getAll();

    CategoryResponseDto update(Long id, CategoryRequestDto requestDto);

    void delete(Long id);
}