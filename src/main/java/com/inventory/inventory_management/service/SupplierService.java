package com.inventory.inventory_management.service;

import com.inventory.inventory_management.dto.SupplierRequestDto;
import com.inventory.inventory_management.dto.SupplierResponseDto;

import java.util.List;

public interface SupplierService {

    SupplierResponseDto create(SupplierRequestDto requestDto);

    SupplierResponseDto getById(Long id);

    List<SupplierResponseDto> getAll();

    SupplierResponseDto update(Long id, SupplierRequestDto requestDto);

    void delete(Long id);
}