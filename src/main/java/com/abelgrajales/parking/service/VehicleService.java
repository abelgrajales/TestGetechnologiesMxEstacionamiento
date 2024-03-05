package com.abelgrajales.parking.service;

import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.model.VehicleType;
import com.abelgrajales.parking.repository.VehicleRepository;
import com.abelgrajales.parking.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);
    }

    public Vehicle saveOrUpdate(Vehicle vehicle){
        Optional<Vehicle> vehicleName = vehicleRepository.findByPlate(vehicle.getPlate());

        if (!vehicleName.isPresent()){
            return vehicleRepository.save(vehicle);
        }else {
            throw new IllegalArgumentException("Vehiculo ya registrado");
        }

    }

    public void delete(Long id){
        vehicleRepository.deleteById(id);
    }
}
