package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Doctor;
import com.example.proyectoapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping("/doctor")
    public ResponseEntity save( @RequestBody Doctor doctor){
        ResponseEntity<?> response;
        try {
            response = doctorService.save(doctor);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @GetMapping("/doctores")
    public ResponseEntity<?> findAll() {
        ResponseEntity<?> response;
        try {
            response =  doctorService.findAll();

        } catch (Exception e) {
          response= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }



    @GetMapping("/doctor/{id}")
    public ResponseEntity findById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = ResponseEntity.ok(doctorService.findById(id).getBody());
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;

    }
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        ResponseEntity<?> response;
        try {
            response = doctorService.deleteById(id);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @PutMapping("/doctor")
    public ResponseEntity update(@RequestBody Doctor doctor){
        ResponseEntity<?> response;
        try {
            response =  doctorService.update(doctor);
        }  catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }


}
