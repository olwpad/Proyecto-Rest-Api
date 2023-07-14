package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Paciente;
import com.example.proyectoapi.repository.CitaRepository;
import com.example.proyectoapi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final CitaRepository citaRepository;

    // Guarda un nuevo paciente en la base de datos
    public ResponseEntity<?> save(Paciente paciente) {
        try {
            boolean pacienteExiste = pacienteRepository.existsById(paciente.getId());
            if (pacienteExiste) {
                return ResponseEntity.badRequest().body("El Paciente ya está registrado");
            } else {
                pacienteRepository.save(paciente);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el paciente", e);
        }
    }

    // Recupera todos los pacientes registrados en el sistema
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    // Busca un paciente por su identificador
    public Optional<Paciente> findById(String id) {
        return pacienteRepository.findById(id);
    }

    // Elimina un paciente por su identificador, si no tiene citas pendientes
    public ResponseEntity deleteById(String id) {
        try {
            boolean pacienteExistenCitas = citaRepository.existsBynumeroDeCedula(id);
            if (pacienteExistenCitas) {
                return ResponseEntity.badRequest().body("No puedes borrar al paciente porque tiene citas pendientes");
            } else {
                pacienteRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al borrar el paciente", e);
        }
    }

    // Actualiza la información de un paciente existente
    public ResponseEntity<?> update(Paciente paciente) {
        try {
            boolean pacienteExiste = pacienteRepository.existsById(paciente.getId());
            if (!pacienteExiste) {
                return ResponseEntity.badRequest().body("No puedes editar al paciente porque no existe");
            } else {
                Paciente pacienteExistente = pacienteRepository.findById(paciente.getId()).orElse(null);
                if (pacienteExistente != null) {
                    pacienteExistente.setEmail(paciente.getEmail());
                    pacienteExistente.setTelefono(paciente.getTelefono());
                } else {
                    return ResponseEntity.badRequest().body("El paciente  no existe");
                }
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar el paciente", e);
        }
    }
}
