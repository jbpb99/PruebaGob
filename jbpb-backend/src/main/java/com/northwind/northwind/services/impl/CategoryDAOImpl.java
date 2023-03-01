package com.northwind.northwind.services.impl;

import com.northwind.northwind.entities.Category;
import com.northwind.northwind.entities.Employee;
import com.northwind.northwind.repositories.CategoryRepository;
import com.northwind.northwind.services.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private CategoryRepository categoryRepository;

    //Get
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }
    //Get by ID
    public Optional<Category> findById(int id) {
        return (Optional<Category>) categoryRepository.findById(id);
    }
    //Post
    public List<Category> saveAndFlush(Category category) {
        categoryRepository.saveAndFlush(category);

        return null;
    }

    //Delete
    @Override
    public void deleteById(int id){
        categoryRepository.deleteById(id);

    }

    @Override
    public Optional<Category> updateCategory(Category category, int id) {
        Optional<Category> categorias = categoryRepository.findById(id);

        Category categoria;

        if(categorias.isPresent()) {
            categoria = categorias.get();

            categoria.setCategoryName(category.getCategoryName());
            categoria.setDescription(category.getDescription());

            categoryRepository.saveAndFlush(categoria);

            return Optional.of(categoria);
        }

        return Optional.empty();
    }



}
