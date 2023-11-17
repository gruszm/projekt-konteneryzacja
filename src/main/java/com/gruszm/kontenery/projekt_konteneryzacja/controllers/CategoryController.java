package com.gruszm.kontenery.projekt_konteneryzacja.controllers;

import com.gruszm.kontenery.projekt_konteneryzacja.entities.Category;
import com.gruszm.kontenery.projekt_konteneryzacja.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController
{
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllUsers()
    {
        return categoryService.findAll();
    }
}
