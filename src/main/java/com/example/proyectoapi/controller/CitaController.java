package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Cita;
import com.example.proyectoapi.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CitaController {
    private final  CitaService citaService;


    @PostMapping("/citas")
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
    public List<Cita> findAll(){
        return citaService.findAll();
    }
    @GetMapping("/cita/{id}")
    public Cita findById(@PathVariable String id){
        return citaService.findById(id).get();
    }
    @DeleteMapping("/cita/{id}")
    public void deleteById(@PathVariable String id){
        citaService.deleteById(id);
    }

    @PutMapping("/citas")
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
