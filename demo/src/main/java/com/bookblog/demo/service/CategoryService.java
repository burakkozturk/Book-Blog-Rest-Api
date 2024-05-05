package com.bookblog.demo.service;

import com.bookblog.demo.dto.CategoryDto;
import com.bookblog.demo.entity.Category;
import com.bookblog.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){

        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Optional<Category> getCategoryById(Long categoryId){

        Optional<Category> category = categoryRepository.findById(categoryId);
        return category;
    }

    public Category saveCategory(CategoryDto categoryDto){

        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long categoryId,CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if(!optionalCategory.isPresent()){
            return Optional.empty();
        }

        Category category = optionalCategory.get();
        category.setTitle(categoryDto.getTitle());
        return Optional.of(categoryRepository.save(category));
    }

    public void removeCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public void removeAllCategory(){
        categoryRepository.deleteAll();
    }
}
