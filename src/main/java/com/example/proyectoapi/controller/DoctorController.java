package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Doctor;
import com.example.proyectoapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping("/doctores")
    public void save( @RequestBody Doctor doctor){
        doctorService.save(doctor);
    }
    @GetMapping("/doctores")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }
    @GetMapping("/doctores/{id}")
    public Doctor findById(@PathVariable  String id){
        return doctorService.findById(id).get();
    }
    @DeleteMapping("/doctor/{id}")
    public void deleteById(@PathVariable String id){
        doctorService.deleteById(id);
    }

    @PutMapping("/doctores")
    public void update(@RequestBody Doctor doctor){
        doctorService.save(doctor);

    }

}
