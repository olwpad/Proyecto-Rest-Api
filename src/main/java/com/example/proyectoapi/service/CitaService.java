package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Cita;
import com.example.proyectoapi.repository.CitaRepository;
import com.example.proyectoapi.repository.DoctorRepository;
import com.example.proyectoapi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//crea contructores
    @Service
public class CitaService {
    private final CitaRepository citaRepository;
    private final DoctorRepository doctorRepository;
    private  final PacienteRepository pacienteRepository;

    public ResponseEntity<?> save(Cita cita) {
        try {
            boolean existeDoctor = doctorRepository.existsById(cita.getCedulaDoctor());
            boolean existePaciente = pacienteRepository.existsById(cita.getNumeroDeCedula());
            if (!existeDoctor && !existePaciente) {
                return ResponseEntity.badRequest().body("El doctor no está registrado y tampoco el paciente.");
            } else if (!existeDoctor) {
                return ResponseEntity.badRequest().body("El doctor no está registrado.");
            } else if (!existePaciente) {
                return ResponseEntity.badRequest().body("El paciente no está registrado.");
            }else{
                citaRepository.save(cita);
                return ResponseEntity.ok().build();
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar la cita", e);
        }
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
    public ResponseEntity<?> update(Cita citaActualizada) {
        try {
            boolean existeDoctor = doctorRepository.existsById(citaActualizada.getCedulaDoctor());
            boolean existePaciente = pacienteRepository.existsById(citaActualizada.getNumeroDeCedula());

            if (!existeDoctor && !existePaciente) {
                return ResponseEntity.badRequest().body("El doctor no está registrado y tampoco el paciente.");
            } else if (!existeDoctor) {
                return ResponseEntity.badRequest().body("El doctor no está registrado.");
            } else if (!existePaciente) {
                return ResponseEntity.badRequest().body("El paciente no está registrado.");
            } else {
                Optional<Cita> citaExistente = citaRepository.findById(citaActualizada.getId());
                if (citaExistente.isPresent()) {
                    Cita cita = citaExistente.get();
                    cita.setEspecialidad(citaActualizada.getEspecialidad());
                    cita.setHora(citaActualizada.getHora());
                    citaRepository.save(cita);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.badRequest().body("La cita no existe"); // Si la cita no existe, retorna 404 Not Found
                }
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar la cita", e);
        }
    }


    // ...
    }


