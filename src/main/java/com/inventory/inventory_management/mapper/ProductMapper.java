package com.inventory.inventory_management.mapper;

import com.inventory.inventory_management.dto.ProductResponseDto;
import com.inventory.inventory_management.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.name", target = "supplierName")
    ProductResponseDto toResponseDto(Product product);
}