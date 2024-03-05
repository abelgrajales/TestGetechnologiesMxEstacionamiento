package com.abelgrajales.parking.repository;

import com.abelgrajales.parking.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

    public Optional<VehicleType> findByName(String name);
}
