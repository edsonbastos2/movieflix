package com.edsonBastos.catalog.controller;

import com.edsonBastos.catalog.entity.Category;
import com.edsonBastos.catalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogo-filmes/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<Category> getAllCategoties() {
        return service.getAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        Optional<Category> categoryById = service.getCategoryById(id);

        if(categoryById.isPresent()) {
            return categoryById.get();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
    }
}
