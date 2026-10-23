package org.example.inventorymanagementproject.mapper;

import org.example.inventorymanagementproject.dto.request.CategoryRequestDto;
import org.example.inventorymanagementproject.dto.response.CategoryResponseDto;
import org.example.inventorymanagementproject.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDto dto) {
        return Category.builder()
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    public CategoryResponseDto toResponseDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public void updateEntity(Category category, CategoryRequestDto dto) {
        category.setName(dto.name());
        category.setDescription(dto.description());
    }
}