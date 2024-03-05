package com.abelgrajales.parking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Data
@Table(name = "stay")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    //Hora de entrada
    private LocalDateTime entryTime;

    //Hora de salida
    private LocalDateTime exitTime;

    //Minutos acumulados
    private Long minutes = Long.valueOf(0);
}
