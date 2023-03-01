package com.northwind.northwind.services;

import com.northwind.northwind.entities.Shipper;

import java.util.List;
import java.util.Optional;

public interface ShipperDAO {
    List<Shipper> findAll();

    Optional<Shipper> findById(int id);

    List<Shipper> saveAndFlush(Shipper shipper);

    void deleteById(int id);

    Optional<Shipper> updateShipper(Shipper shipper, int id);
}
