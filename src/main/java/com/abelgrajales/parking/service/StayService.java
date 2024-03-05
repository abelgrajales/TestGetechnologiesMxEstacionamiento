package com.abelgrajales.parking.service;

import com.abelgrajales.parking.model.Stay;
import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.repository.StayRepository;
import com.abelgrajales.parking.repository.VehicleRepository;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StayService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private StayRepository stayRepository;

    public List<Stay> getStays() {
        return stayRepository.findAll();
    }

    public Optional<Stay> getStayById(Long id) {
        return stayRepository.findById(id);
    }

    public Stay registerEntry(String plate) {
        Optional<Vehicle> vehicleExist = vehicleRepository.findByPlate(plate);

        if (vehicleExist.isPresent()) {

            Stay stay = new Stay();
            stay.setVehicle(vehicleExist.get());
            stay.setEntryTime(LocalDateTime.now());
            return stayRepository.save(stay);

        } else {
            throw new IllegalArgumentException("El vehículo no está registrado");
        }
    }

    public Stay registerExit(String plate) {
        Optional<Vehicle> vehicleExist = vehicleRepository.findByPlate(plate);

        if (vehicleExist.isPresent()) {
            Vehicle vehicle = vehicleExist.get();
            List<Stay> stays = stayRepository.findByVehicle(vehicle);

            if (!stays.isEmpty()) {
                Stay lastStay = stays.get(stays.size() - 1);

                if (lastStay.getExitTime() == null) {

                    System.out.println(vehicle.getVehicleType());
                    if (vehicle.getVehicleType().getName().equals("Oficial")) {
                        lastStay.setExitTime(LocalDateTime.now());

                    } else if (vehicle.getVehicleType().getName().equals("Residente")) {
                        lastStay.setExitTime(LocalDateTime.now());
                        Long minutes = Duration.between(lastStay.getEntryTime(), lastStay.getExitTime()).toMinutes();
                        lastStay.setMinutes(lastStay.getMinutes() + minutes);
                    } else if (vehicle.getVehicleType().getName().equals("No residente")) {
                        lastStay.setExitTime(LocalDateTime.now());
                        Long minutes = Duration.between(lastStay.getEntryTime(), lastStay.getExitTime()).toMinutes();
                        double total = minutes * 0.5;
                        System.out.println("Total a pagar" + total);
                    }

                    return stayRepository.save(lastStay);

                } else {
                    throw new IllegalStateException("El vehículo ya registró su salida");
                }
            } else {
                throw new IllegalStateException("El vehículo no tiene estancias registradas.");
            }

        } else {
            throw new IllegalArgumentException("El vehículo no está registrado");
        }
    }

    public void newMonth() {
        List<Vehicle> officialVehicles = vehicleRepository.findByVehicleTypeName("Oficial");

        for (Vehicle vehicle : officialVehicles) {
            List<Stay> stays = stayRepository.findByVehicle(vehicle);
            for (Stay stay : stays) {
                stayRepository.delete(stay);
            }
        }

        List<Vehicle> residentVehicles = vehicleRepository.findByVehicleTypeName("Residente");
        for (Vehicle vehicle : residentVehicles) {
            List<Stay> stays = stayRepository.findByVehicle(vehicle);
            for (Stay stay : stays) {
                stay.setMinutes(Long.valueOf(0));
                stayRepository.save(stay);
            }
        }

    }

    public void residentPay(){
        final double PRICE = 0.5;

        System.out.println("Informe de Pagos de Residentes:");
        System.out.println("Núm. placa \t Tiempo Estacionado (min.) \t Cantidad a Pagar");

        List<Vehicle> vehicles = vehicleRepository.findByVehicleTypeName("Residente");


        for (Vehicle vehicle : vehicles) {
            List<Stay> stays = stayRepository.findByVehicle(vehicle);

            for (Stay stay : stays){
                long minutes = stay.getMinutes();
                double total = minutes * PRICE;

                System.out.printf("%-15s  %-20s  %-1s\n", vehicle.getPlate(), minutes, total);
            }
        }
    }

    public void delete(Long id) {
        stayRepository.deleteById(id);
    }
}
