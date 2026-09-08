package com.inventory.inventory_management.service.impl;

import com.inventory.inventory_management.dto.ProductRequestDto;
import com.inventory.inventory_management.dto.ProductResponseDto;
import com.inventory.inventory_management.entity.Category;
import com.inventory.inventory_management.entity.Product;
import com.inventory.inventory_management.entity.Supplier;
import com.inventory.inventory_management.exception.ResourceNotFoundException;
import com.inventory.inventory_management.mapper.ProductMapper;
import com.inventory.inventory_management.repository.CategoryRepository;
import com.inventory.inventory_management.repository.ProductRepository;
import com.inventory.inventory_management.repository.SupplierRepository;
import com.inventory.inventory_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto create(ProductRequestDto requestDto) {
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with id: " + requestDto.getCategoryId()));

        Supplier supplier = supplierRepository.findById(requestDto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Supplier not found with id: " + requestDto.getSupplierId()));

        Product product = new Product();
        product.setName(requestDto.getName());
        product.setSku(requestDto.getSku());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        product.setQuantity(requestDto.getQuantity());
        product.setReorderLevel(requestDto.getReorderLevel());
        product.setCategory(category);
        product.setSupplier(supplier);
        product.setIsDeleted(false);

        Product saved = productRepository.save(product);
        return productMapper.toResponseDto(saved);
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return productMapper.toResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findByIsDeletedFalse()
                .stream()
                .map(productMapper::toResponseDto)
                .toList();
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto requestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with id: " + requestDto.getCategoryId()));

        Supplier supplier = supplierRepository.findById(requestDto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Supplier not found with id: " + requestDto.getSupplierId()));

        product.setName(requestDto.getName());
        product.setSku(requestDto.getSku());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        product.setQuantity(requestDto.getQuantity());
        product.setReorderLevel(requestDto.getReorderLevel());
        product.setCategory(category);
        product.setSupplier(supplier);

        Product updated = productRepository.save(product);
        return productMapper.toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.setIsDeleted(true);
        productRepository.save(product);
    }
}