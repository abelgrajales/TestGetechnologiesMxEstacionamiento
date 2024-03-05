package com.abelgrajales.parking.controller;

import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.model.VehicleType;
import com.abelgrajales.parking.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/vehiclestype")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public List<VehicleType> getVehiclesType(){
        return vehicleTypeService.getVehicleType();
    }

    @GetMapping("/{vehicleTypeId}")
    public Optional<VehicleType> getById(@PathVariable("vehicleTypeId") Long vehicleTypeId){
        return vehicleTypeService.getVehicleTypeById(vehicleTypeId);
    }

    @PostMapping
    public ResponseEntity saveUpdate(@RequestBody VehicleType vehicleType){


        try {
            Map<String,VehicleType> response = new HashMap<String, VehicleType>();
            vehicleTypeService.saveOrUpdate(vehicleType);
            response.put("Guardado", vehicleType);
            return ResponseEntity.accepted().body(response);

        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @DeleteMapping("/delete/{vehicleTypeId}")
    public void deleteById(@PathVariable("vehicleTypeId") Long vehicleTypeId){
        vehicleTypeService.delete(vehicleTypeId);
    }
}
