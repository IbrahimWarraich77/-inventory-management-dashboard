package com.inventory.inventory_management.repository;

import com.inventory.inventory_management.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void shouldSaveAndRetrieveCategory() {
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("Electronic items and gadgets");

        Category savedCategory = categoryRepository.save(category);
        Optional<Category> foundCategory = categoryRepository.findById(savedCategory.getId());

        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Electronics");
    }

    @Test
    void shouldReturnEmptyWhenCategoryNotFound() {
        Optional<Category> foundCategory = categoryRepository.findById(999L);

        assertThat(foundCategory).isEmpty();
    }
}