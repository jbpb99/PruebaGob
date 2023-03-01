package com.northwind.northwind.services.impl;

import com.northwind.northwind.dto.ProductDto;
import com.northwind.northwind.entities.Category;
import com.northwind.northwind.entities.Product;
import com.northwind.northwind.entities.Supplier;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.repositories.CategoryRepository;
import com.northwind.northwind.repositories.ProductRepository;
import com.northwind.northwind.repositories.SupplierRepository;
import com.northwind.northwind.services.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return (Optional<Product>) productRepository.findById(id);
    }

    @Override
    public Product saveAndFlush(ProductDto productDto) {
        Product product = new Product();
        Optional<Supplier> supplier = supplierRepository.findById(productDto.getSupplier());
        Optional<Category> category = categoryRepository.findById(productDto.getCategory());

        product.setProductName(productDto.getProductName());
        if(supplier.isPresent()) {
            product.setSupplier(supplier.get());
        }else {
            return null;
        }
        if(category.isPresent()) {
            product.setCategory(category.get());
        }else {
            return null;
        }
        product.setUnit(productDto.getUnit());
        product.setPrice(productDto.getPrice());

        productRepository.saveAndFlush(product);

        return null;
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> updateProduct(Product product, int id) {
        Optional<Product> products = productRepository.findById(id);
        Product productObj;

        if(products.isPresent()) {
            productObj = products.get();

            productObj.setProductName(product.getProductName());
            productObj.setUnit(product.getUnit());
            productObj.setPrice(product.getPrice());

            productRepository.saveAndFlush(productObj);

            return Optional.of(productObj);
        }

        return Optional.empty();
    }
}
