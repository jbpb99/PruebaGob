package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.CategoryDto;
import com.northwind.northwind.entities.Category;
import com.northwind.northwind.mapstruct.mappers.DTOMapper;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.services.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    //DAO
    private final CategoryDAO categoryDAO;

    //Mapper for structured data
    private DTOMapper dtoMapper;

    @Autowired
    public CategoryController(CategoryDAO categoryDAO, DTOMapper dtoMapper) {
        this.categoryDAO = categoryDAO;
        this.dtoMapper = dtoMapper;
    }

    //Get categories
    @GetMapping
    @RequestMapping("/get")
    public List<CategoryDto> getCategories() {
        List<Category> categories;
        List<CategoryDto> categoryDtos = new ArrayList<>();

        categories = categoryDAO.findAll();
        categories.forEach(category -> {
            categoryDtos.add(dtoMapper.categoryDto(category));
        });



        //categories = categoryDAO.findAll();
        return categoryDtos;
    }

    //Get by ID
    @GetMapping("/get/{id}")
    public CategoryDto getCatById(@PathVariable int id) {
        Optional<Category> categories;
        CategoryDto categoryDtos;

        //Category category;

        categories = categoryDAO.findById(id);

        if(categories.isPresent()) {
            categoryDtos = dtoMapper.categoryDto(categories.get());

            //category = categories.get();

            return categoryDtos;
        }

        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public Category saveCategory(@RequestBody Category categoryBody) {
        categoryDAO.saveAndFlush(categoryBody);

        return categoryBody;
    }

    //Delete
    @RequestMapping("/delete/{id}")
    public Category deleteCategory(@PathVariable int id) {
        categoryDAO.deleteById(id);

        return null;
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public CategoryDto updateCategory(@RequestBody Category categoryBody, @PathVariable int id) {
        Optional<Category> categorias = categoryDAO.updateCategory(categoryBody, id);
        CategoryDto categoryDto;

        if(categorias.isPresent()) {
            categoryDto = dtoMapper.categoryDto(categorias.get());

            return categoryDto;
        }


        return null;
    }
}
