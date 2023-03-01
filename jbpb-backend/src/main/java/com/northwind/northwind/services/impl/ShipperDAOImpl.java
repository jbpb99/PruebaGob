package com.northwind.northwind.services.impl;

import com.northwind.northwind.entities.Shipper;
import com.northwind.northwind.repositories.ShipperRepository;
import com.northwind.northwind.services.ShipperDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperDAOImpl implements ShipperDAO {
    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public List<Shipper> findAll() {
        return (List<Shipper>) shipperRepository.findAll();
    }

    @Override
    public Optional<Shipper> findById(int id) {
        return (Optional<Shipper>) shipperRepository.findById(id);
    }

    @Override
    public List<Shipper> saveAndFlush(Shipper shipper) {
        shipperRepository.saveAndFlush(shipper);

        return null;
    }

    @Override
    public void deleteById(int id) {
        shipperRepository.changeActive(id);
    }

    @Override
    public Optional<Shipper> updateShipper(Shipper shipper, int id) {
        Optional<Shipper> shippers = shipperRepository.findById(id);
        Shipper shipperObj;

        if(shippers.isPresent()) {
            shipperObj = shippers.get();

            shipperObj.setShipperName(shipper.getShipperName());
            shipperObj.setPhone(shipper.getPhone());

            shipperRepository.saveAndFlush(shipperObj);

            return Optional.of(shipperObj);
        }

        return null;
    }
}
