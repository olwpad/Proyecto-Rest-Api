package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Paciente;
import com.example.proyectoapi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PacienteController {
    private final PacienteService pacienteService;
    @PostMapping("/paciente")
    public  ResponseEntity save(@RequestBody Paciente paciente){
            ResponseEntity<?> response;
            try {
                response = pacienteService.save(paciente);
            }  catch (Exception e) {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return response;
        }



    @GetMapping("/pacientes")
    public ResponseEntity<?> findAll() {
        ResponseEntity<?> response;
        try {
            response =  pacienteService.findAll();

        } catch (Exception e) {
            response= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }


    @GetMapping("/paciente/{id}")
    public ResponseEntity findById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = ResponseEntity.ok(pacienteService.findById(id).getBody());
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;

    }
    @DeleteMapping ("/paciente/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = pacienteService.deleteById(id);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
    @PutMapping("/paciente")
    public ResponseEntity update(@RequestBody Paciente paciente){
        ResponseEntity<?> response;
        try {
            response =  pacienteService.update(paciente);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}
