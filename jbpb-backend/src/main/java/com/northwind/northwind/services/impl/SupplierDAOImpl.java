package com.northwind.northwind.services.impl;

import com.northwind.northwind.entities.Supplier;
import com.northwind.northwind.repositories.ShipperRepository;
import com.northwind.northwind.repositories.SupplierRepository;
import com.northwind.northwind.services.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierDAOImpl implements SupplierDAO {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return (Optional<Supplier>) supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> saveAndFlush(Supplier supplier) {
        supplierRepository.saveAndFlush(supplier);

        return null;
    }

    @Override
    public void deleteById(int id) {
        supplierRepository.changeActive(id);
    }

    @Override
    public Optional<Supplier> updateSupplier(Supplier supplier, int id) {
        Optional<Supplier> suppliers = supplierRepository.findById(id);
        Supplier supplierObj;

        if(suppliers.isPresent()) {
            supplierObj = suppliers.get();

            supplierObj.setSupplierName(supplier.getSupplierName());
            supplierObj.setContactName(supplier.getContactName());
            supplierObj.setAddress(supplier.getAddress());
            supplierObj.setCity(supplier.getCity());
            supplierObj.setPostalCode(supplier.getPostalCode());
            supplierObj.setCountry(supplier.getCountry());
            supplierObj.setPhone(supplier.getPhone());

            supplierRepository.saveAndFlush(supplierObj);

            return Optional.of(supplierObj);
        }

        return Optional.empty();
    }
}
