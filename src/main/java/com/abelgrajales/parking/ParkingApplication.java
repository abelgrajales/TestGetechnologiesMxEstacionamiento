package com.abelgrajales.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);

		Calendar calendar = Calendar.getInstance();

		System.out.println(calendar.getTime());
	}

}
