package com.northwind.northwind.services;

import com.northwind.northwind.dto.ProductDto;
import com.northwind.northwind.entities.Product;
import com.northwind.northwind.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    List<Product> findAll();

    Optional<Product> findById(int id);

    Product saveAndFlush(ProductDto product);

    void deleteById(int id);

    Optional<Product> updateProduct(Product product, int id);
}
