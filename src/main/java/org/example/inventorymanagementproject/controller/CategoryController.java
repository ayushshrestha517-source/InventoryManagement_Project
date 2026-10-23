package org.example.inventorymanagementproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.inventorymanagementproject.dao.CategoryDao;
import org.example.inventorymanagementproject.dto.request.CategoryRequestDto;
import org.example.inventorymanagementproject.dto.response.ApiResponse;
import org.example.inventorymanagementproject.dto.response.CategoryResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDao categoryDao;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> createCategory(@Valid @RequestBody CategoryRequestDto dto) {
        return ResponseEntity.ok(ApiResponse.success(categoryDao.createCategory(dto),"Category created successfully."));
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories() {
        return ResponseEntity.ok(ApiResponse.success(categoryDao.getAllCategories(),"All Categories retrieved successfully"));
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(categoryDao.getCategoryById(id),"Category of id "+ id +" retrieved successfully"));
    }


}