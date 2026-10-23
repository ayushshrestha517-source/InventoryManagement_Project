package org.example.inventorymanagementproject.dao;

import org.example.inventorymanagementproject.dto.request.CategoryRequestDto;
import org.example.inventorymanagementproject.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryDao {

    CategoryResponseDto createCategory(CategoryRequestDto dto);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto getCategoryById(Long id);

//    CategoryResponseDto updateCategory(Long id, CategoryRequestDto dto);

//    void deleteCategory(Long id);
}