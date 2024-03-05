package com.abelgrajales.parking.repository;

import com.abelgrajales.parking.model.Stay;
import com.abelgrajales.parking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {

    public List<Stay> findByVehicle(Vehicle vehicle);

}
