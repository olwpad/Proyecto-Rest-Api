package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Cita;
import com.example.proyectoapi.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CitaController {
    private final  CitaService citaService;


    @PostMapping("/cita")
    public ResponseEntity<?> save(@RequestBody Cita cita) {
        ResponseEntity<?> response;
        try {
            response = citaService.save(cita);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
    @GetMapping("/citas")
    public ResponseEntity<?> findAll() {
        ResponseEntity<?> response;
        try {
            response =  citaService.findAll();

        } catch (Exception e) {
            response= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
    @GetMapping("/cita/{id}")
    public ResponseEntity findById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = ResponseEntity.ok(citaService.findById(id).getBody());
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;

    }
    @DeleteMapping("/cita/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = citaService.deleteById(id);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @PutMapping("/cita")
    public  ResponseEntity update(@RequestBody Cita cita){
        ResponseEntity<?> response;
        try {
            response =  citaService.update(cita);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }


}
