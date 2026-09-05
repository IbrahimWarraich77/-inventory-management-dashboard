package com.inventory.inventory_management.controller;

import com.inventory.inventory_management.dto.CategoryRequestDto;
import com.inventory.inventory_management.dto.CategoryResponseDto;
import com.inventory.inventory_management.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@Valid @RequestBody CategoryRequestDto requestDto) {
        CategoryResponseDto created = categoryService.create(requestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody CategoryRequestDto requestDto) {
        return ResponseEntity.ok(categoryService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}