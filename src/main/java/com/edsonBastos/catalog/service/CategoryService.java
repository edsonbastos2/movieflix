package com.edsonBastos.catalog.service;

import com.edsonBastos.catalog.controller.request.CategoryRequest;
import com.edsonBastos.catalog.controller.response.CategoryResponse;
import com.edsonBastos.catalog.entity.Category;
import com.edsonBastos.catalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public Optional<Category> getCategoryById(Long id){
        return repository.findById(id);
    }

    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
}
