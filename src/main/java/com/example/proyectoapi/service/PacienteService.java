package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Paciente;
import com.example.proyectoapi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(String id) {
        return pacienteRepository.findById(id);
    }

    public void deleteById(String id) {
        pacienteRepository.deleteById(id);
    }
}
