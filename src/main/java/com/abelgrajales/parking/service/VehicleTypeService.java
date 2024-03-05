package com.abelgrajales.parking.service;

import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.model.VehicleType;
import com.abelgrajales.parking.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> getVehicleTypeById(Long id){
        return vehicleTypeRepository.findById(id);
    }

    public VehicleType saveOrUpdate(VehicleType vehicleType){
        Optional<VehicleType> vehicleTypeName = vehicleTypeRepository.findByName(vehicleType.getName());

        if (!vehicleTypeName.isPresent()){
            return vehicleTypeRepository.save(vehicleType);
        }else {
            throw new IllegalArgumentException("Tipo de vehiculo ya registrado");
        }

    }

    public void delete(Long id){
        vehicleTypeRepository.deleteById(id);
    }

}
