package com.inventory.inventory_management.controller;

import com.inventory.inventory_management.dto.SupplierRequestDto;
import com.inventory.inventory_management.dto.SupplierResponseDto;
import com.inventory.inventory_management.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDto> create(@Valid @RequestBody SupplierRequestDto requestDto) {
        SupplierResponseDto created = supplierService.create(requestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAll() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody SupplierRequestDto requestDto) {
        return ResponseEntity.ok(supplierService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}