package com.example.proyectoapi.controller;

import com.example.proyectoapi.model.Paciente;
import com.example.proyectoapi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PacienteController {
    private final PacienteService pacienteService;
    @PostMapping("/pacientes")
    public void save(@RequestBody Paciente paciente){
        pacienteService.save(paciente);


    }
    @GetMapping("/pacientes")
    public List<Paciente> findAll(){
        return  pacienteService.findAll();
    }
    @GetMapping("/paciente/{id}")
    public Paciente findById(@PathVariable String id){
        return pacienteService.findById(id).get();

    }
    @DeleteMapping ("/paciente/{id}")
    public void deleteById(@PathVariable  String id){
        pacienteService.deleteById(id);
    }
    @PutMapping("/pacientes")
    public void update(@RequestBody Paciente paciente){
        pacienteService.save(paciente);

    }
}
