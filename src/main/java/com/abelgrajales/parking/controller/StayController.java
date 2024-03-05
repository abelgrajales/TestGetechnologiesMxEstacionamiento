package com.abelgrajales.parking.controller;

import com.abelgrajales.parking.model.Stay;
import com.abelgrajales.parking.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/stays")
public class StayController {

    @Autowired
    private StayService stayService;


    @GetMapping
    public List<Stay> getStays(){
        return stayService.getStays();
    }

    @GetMapping("/{stayId}")
    public Optional<Stay> getById(@PathVariable("stayId") Long stayId){
        return stayService.getStayById(stayId);
    }

    @PostMapping("/registerentry")
    public ResponseEntity registerEntry(@RequestParam String plate){


        try {
            Map<String,Stay> response = new HashMap<String, Stay>();

            response.put("Guardado", stayService.registerEntry(plate));
            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PostMapping("/registerexit")
    public ResponseEntity registerExit(@RequestParam String plate){


        try {
            Map<String,Stay> response = new HashMap<String, Stay>();

            response.put("Salida", stayService.registerExit(plate));
            return ResponseEntity.accepted().body(response);
        } catch (IllegalArgumentException e) {
            Map<String,String> response = new HashMap<String, String>();
            response.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PostMapping("/newmonth")
    public ResponseEntity newMonth(){

        try {
            stayService.newMonth();
            return ResponseEntity.ok().body("Nuevo mes comenzado correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al iniciar el nuevo mes");
        }
    }

    @DeleteMapping("/delete/{vehicleId}")
    public void deleteById(@PathVariable("vehicleId") Long vehicleTypeId){
        stayService.delete(vehicleTypeId);
    }

    @PostMapping("/generatereport")
    public ResponseEntity generateResidentPay(){
        try {
            stayService.residentPay();
            return ResponseEntity.ok().body("Informe generado correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al generar el informe de pagos de residentes");
        }
    }
}
