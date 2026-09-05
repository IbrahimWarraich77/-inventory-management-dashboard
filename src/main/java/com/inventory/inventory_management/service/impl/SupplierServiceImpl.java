package com.inventory.inventory_management.service.impl;

import com.inventory.inventory_management.dto.SupplierRequestDto;
import com.inventory.inventory_management.dto.SupplierResponseDto;
import com.inventory.inventory_management.entity.Supplier;
import com.inventory.inventory_management.exception.ResourceNotFoundException;
import com.inventory.inventory_management.mapper.SupplierMapper;
import com.inventory.inventory_management.repository.SupplierRepository;
import com.inventory.inventory_management.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public SupplierResponseDto create(SupplierRequestDto requestDto) {
        Supplier supplier = supplierMapper.toEntity(requestDto);
        Supplier saved = supplierRepository.save(supplier);
        return supplierMapper.toResponseDto(saved);
    }

    @Override
    public SupplierResponseDto getById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        return supplierMapper.toResponseDto(supplier);
    }

    @Override
    public List<SupplierResponseDto> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::toResponseDto)
                .toList();
    }

    @Override
    public SupplierResponseDto update(Long id, SupplierRequestDto requestDto) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));

        supplier.setName(requestDto.getName());
        supplier.setContactPerson(requestDto.getContactPerson());
        supplier.setPhone(requestDto.getPhone());
        supplier.setEmail(requestDto.getEmail());
        supplier.setAddress(requestDto.getAddress());

        Supplier updated = supplierRepository.save(supplier);
        return supplierMapper.toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplierRepository.delete(supplier);
    }
}