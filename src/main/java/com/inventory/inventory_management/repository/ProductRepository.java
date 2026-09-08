package com.inventory.inventory_management.repository;

import com.inventory.inventory_management.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByIsDeletedFalse(Pageable pageable);

    Page<Product> findByIsDeletedFalseAndNameContainingIgnoreCase(String name, Pageable pageable);
}