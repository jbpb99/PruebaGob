package com.northwind.northwind.services;

import com.northwind.northwind.entities.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierDAO {
    List<Supplier> findAll();

    Optional<Supplier> findById(int id);

    List<Supplier> saveAndFlush(Supplier supplier);

    void deleteById(int id);

    Optional<Supplier> updateSupplier(Supplier supplier, int id);
}
