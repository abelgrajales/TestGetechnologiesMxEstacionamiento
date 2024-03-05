package com.abelgrajales.parking.controller;

import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.model.VehicleType;
import com.abelgrajales.parking.service.VehicleService;
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
@RequestMapping(path = "api/v1/vehicles")
public class VehiclesController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public List<Vehicle> getVehicles(){
        return vehicleService.getVehicles();
    }

    @GetMapping("/{vehicleId}")
    public Optional<Vehicle> getById(@PathVariable("vehicleId") Long vehicleId){
        return vehicleService.getVehicleById(vehicleId);
    }

    @PostMapping("/registerofficial")
    public ResponseEntity saveUpdateOfficial(@RequestBody Vehicle vehicle){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(Long.valueOf(1));
        vehicleType.setName("Oficial");

        try {
            vehicle.setVehicleType(vehicleType);
            Map<String,Vehicle> response = new HashMap<String, Vehicle>();
            vehicleService.saveOrUpdate(vehicle);
            response.put("Guardado", vehicle);
            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/registerresident")
    public ResponseEntity saveUpdateResident(@RequestBody Vehicle vehicle){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(Long.valueOf(2));
        vehicleType.setName("Residente");

        try {
            vehicle.setVehicleType(vehicleType);
            Map<String,Vehicle> response = new HashMap<String, Vehicle>();
            vehicleService.saveOrUpdate(vehicle);
            response.put("Guardado", vehicle);
            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/registernonresident")
    public ResponseEntity saveUpdateNonResident(@RequestBody Vehicle vehicle){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(Long.valueOf(3));
        vehicleType.setName("No residente");

        try {
            vehicle.setVehicleType(vehicleType);
            Map<String,Vehicle> response = new HashMap<String, Vehicle>();
            vehicleService.saveOrUpdate(vehicle);
            response.put("Guardado", vehicle);
            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/delete/{vehicleId}")
    public void deleteById(@PathVariable("vehicleId") Long vehicleTypeId){
        vehicleService.delete(vehicleTypeId);
    }
}
