package com.inventory.inventory_management.mapper;

import com.inventory.inventory_management.dto.CategoryRequestDto;
import com.inventory.inventory_management.dto.CategoryResponseDto;
import com.inventory.inventory_management.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequestDto dto);

    CategoryResponseDto toResponseDto(Category category);
}