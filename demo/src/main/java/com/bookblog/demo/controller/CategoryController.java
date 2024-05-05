package com.bookblog.demo.controller;

import com.bookblog.demo.dto.CategoryDto;
import com.bookblog.demo.entity.Category;
import com.bookblog.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long categoryId){
        Optional<Category> category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category();
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{categoryId}")
    public Optional<ResponseEntity<Optional<Category>>> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto){
        Optional<Category> updateCategory = categoryService.updateCategory(categoryId, categoryDto);
        return updateCategory.map(value -> new ResponseEntity<>(updateCategory,HttpStatus.OK));
    }

    @DeleteMapping("/{categoryId}")
    public void removeCategory(@PathVariable Long categoryId){
        categoryService.removeCategory(categoryId);
    }

    @DeleteMapping("/all")
    public void removeAllCategory(){
        categoryService.removeAllCategory();
    }




}
