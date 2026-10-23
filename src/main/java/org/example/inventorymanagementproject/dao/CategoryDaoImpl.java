package org.example.inventorymanagementproject.dao;

import lombok.RequiredArgsConstructor;
import org.example.inventorymanagementproject.dto.request.CategoryRequestDto;
import org.example.inventorymanagementproject.dto.response.CategoryResponseDto;
import org.example.inventorymanagementproject.entity.Category;
import org.example.inventorymanagementproject.exception.DuplicateResourceException;
import org.example.inventorymanagementproject.exception.ResourceNotFoundException;
import org.example.inventorymanagementproject.mapper.CategoryMapper;
import org.example.inventorymanagementproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {
        if (categoryRepository.existsByNameIgnoreCase(dto.name().trim())) {
            throw new DuplicateResourceException("Category already exists");
        }

        Category category = categoryMapper.toEntity(dto);
        category.setName(dto.name().trim());

        return categoryMapper.toResponseDto(categoryRepository.save(category));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return categoryMapper.toResponseDto(category);
    }

}