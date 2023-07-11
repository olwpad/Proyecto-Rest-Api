package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Cita;
import com.example.proyectoapi.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CitaService {
    private final CitaRepository citaRepository;

    public void save (Cita cita){
        citaRepository.save(cita);

    }

    public List<Cita> findAll(){
        return citaRepository.findAll();
    }

    public Optional<Cita> findById(String id) {
        return  citaRepository.findById(id);
    }

    public void deleteById(String id) {
        citaRepository.deleteById(id);
    }
}
