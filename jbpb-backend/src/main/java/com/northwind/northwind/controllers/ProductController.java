package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.ProductDto;
import com.northwind.northwind.entities.Product;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.services.ProductDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<ProductDto> getProduct() {
        List<Product> products = productDAO.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        products.forEach(product -> {
            productDtos.add(DTOMapperClass.productDto(product));
        });

        return productDtos;
    }

    //Get By Id
    @GetMapping
    @RequestMapping("/get/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        Optional<Product> product = productDAO.findById(id);
        ProductDto productDto;

        if(product.isPresent()) {
            productDto = DTOMapperClass.productDto(product.get());

            return productDto;
        }
        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post/")
    public ProductDto saveProduct(@RequestBody ProductDto productBody) {
        productDAO.saveAndFlush(productBody);

        return productBody;
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productDAO.deleteById(id);
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public ProductDto updateProduct(@RequestBody Product productBody, @PathVariable int id) {
        Optional<Product> products = productDAO.updateProduct(productBody, id);
        ProductDto productDto;

        if(products.isPresent()) {
            productDto = DTOMapperClass.productDto(products.get());

            return productDto;
        }

        return null;
    }
}
