package com.inventory.inventory_management.service.impl;

import com.inventory.inventory_management.dto.CategoryRequestDto;
import com.inventory.inventory_management.dto.CategoryResponseDto;
import com.inventory.inventory_management.entity.Category;
import com.inventory.inventory_management.exception.ResourceNotFoundException;
import com.inventory.inventory_management.mapper.CategoryMapper;
import com.inventory.inventory_management.repository.CategoryRepository;
import com.inventory.inventory_management.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto create(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toEntity(requestDto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponseDto(saved);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return categoryMapper.toResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());

        Category updated = categoryRepository.save(category);
        return categoryMapper.toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }
}