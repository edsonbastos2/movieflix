package com.edsonBastos.catalog.mapper;

import com.edsonBastos.catalog.controller.request.CategoryRequest;
import com.edsonBastos.catalog.controller.response.CategoryResponse;
import com.edsonBastos.catalog.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest request) {
        return Category
                .builder()
                .name(request.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category request) {
        return CategoryResponse
                .builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
