package com.abelgrajales.parking.repository;

import com.abelgrajales.parking.model.Vehicle;
import com.abelgrajales.parking.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    public Optional<Vehicle> findByPlate(String plate);

    public List<Vehicle> findByVehicleTypeName(String name);
}
