package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.SupplierDto;
import com.northwind.northwind.entities.Supplier;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.services.SupplierDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierDAO supplierDAO;

    public SupplierController(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<SupplierDto> getSupplier() {
        List<Supplier> suppliers = supplierDAO.findAll();
        List<SupplierDto> supplierDtos = new ArrayList<>();

        suppliers.forEach(supplier -> {
            supplierDtos.add(DTOMapperClass.supplierDto(supplier));
        });

        return supplierDtos;
    }

    //Get By Id
    @GetMapping
    @RequestMapping("/get/{id}")
    public SupplierDto getSupplierById(@PathVariable int id) {
        Optional<Supplier> suppliers = supplierDAO.findById(id);
        SupplierDto supplierDto;

        if(suppliers.isPresent()) {
            supplierDto = DTOMapperClass.supplierDto(suppliers.get());

            return supplierDto;
        }

        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public Supplier saveShipper(@RequestBody Supplier supplierBody) {
        supplierDAO.saveAndFlush(supplierBody);

        return supplierBody;
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteShipper(@PathVariable int id) {
        supplierDAO.deleteById(id);
    }

    //Update
    @PutMapping
    @RequestMapping("update/{id}")
    public SupplierDto updateShipper(@RequestBody Supplier supplierBody, @PathVariable int id) {
        Optional<Supplier> suppliers = supplierDAO.updateSupplier(supplierBody, id);
        SupplierDto supplierDto;

        if(suppliers.isPresent()) {
            supplierDto = DTOMapperClass.supplierDto(suppliers.get());

            return supplierDto;
        }
        return null;
    }
}
