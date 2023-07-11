package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Cita;
import com.example.proyectoapi.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CitaController {
    private final  CitaService citaService;
    @PostMapping("/citas")
    public void save(@RequestBody Cita cita){
        citaService.save(cita);
    }
    @GetMapping("/citas")
    public List<Cita> findAll(){
        return citaService.findAll();
    }
    @GetMapping("/citas/{id}")
    public Cita findById(@PathVariable String id){
        return citaService.findById(id).get();
    }
    @DeleteMapping("/citas/{id}")
    public void deleteById(@PathVariable String id){
        citaService.deleteById(id);
    }

    @PutMapping("/citas")
    public void update(@RequestBody Cita cita){
        citaService.save(cita);

    }


}
