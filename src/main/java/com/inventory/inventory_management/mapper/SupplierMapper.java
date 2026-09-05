package com.inventory.inventory_management.mapper;

import com.inventory.inventory_management.dto.SupplierRequestDto;
import com.inventory.inventory_management.dto.SupplierResponseDto;
import com.inventory.inventory_management.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toEntity(SupplierRequestDto dto);

    SupplierResponseDto toResponseDto(Supplier supplier);
}