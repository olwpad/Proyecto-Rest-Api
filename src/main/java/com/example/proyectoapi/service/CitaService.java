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
            boolean existeCita = citaRepository.existsById(cita.getId());

            if (existeCita) {
                return ResponseEntity.badRequest().body("La cita ya está registrada.");
            } else if (!existeDoctor && !existePaciente) {
                return ResponseEntity.badRequest().body("El doctor no está registrado y tampoco el paciente.");
            } else if (!existeDoctor) {
                return ResponseEntity.badRequest().body("El doctor no está registrado.");
            } else if (!existePaciente) {
                return ResponseEntity.badRequest().body("El paciente no está registrado.");
            } else {
                citaRepository.save(cita);
                return ResponseEntity.ok().body("Cita agregada exitosamente");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar la cita", e);
        }
    }


    public ResponseEntity<?> findAll() {
        try {
            List<Cita> citas = citaRepository.findAll();
            if (citas.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontraron citas");
            }
            return ResponseEntity.ok(citas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> findById(String id) {
        try {
            Optional<Cita> cita= citaRepository.findById(id);
            if (cita.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontro cita");
            }
            return ResponseEntity.ok(cita);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public  ResponseEntity deleteById(String id) {
        try{
            boolean citas=citaRepository.existsById(id);
            if(citas){
                citaRepository.deleteById(id);
                return ResponseEntity.ok().body("cita eliminada correctamente");
            }
            return ResponseEntity.badRequest().body("No se encontro cita");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    public ResponseEntity<?> update(Cita citaActualizada) {
        try {
            // Verifica si el doctor y el paciente existen en la base de datos

            boolean existeDoctor = doctorRepository.existsById(citaActualizada.getCedulaDoctor());
            boolean existePaciente = pacienteRepository.existsById(citaActualizada.getNumeroDeCedula());

            // Si tanto el doctor como el paciente no existen, devuelve un error
            if (!existeDoctor && !existePaciente) {
                return ResponseEntity.badRequest().body("El doctor no está registrado y tampoco el paciente.");

            } else if (!existeDoctor) {
                // Si el doctor no existe, devuelve un error
                return ResponseEntity.badRequest().body("El doctor no está registrado.");
            } else if (!existePaciente) {
                // Si el paciente no existe, devuelve un error
                return ResponseEntity.badRequest().body("El paciente no está registrado.");
            } else {
                // Si el doctor y el paciente existen, busca la cita en la base de datos
                Optional<Cita> citaExistente = citaRepository.findById(citaActualizada.getId());

                // Si la cita existe, actualiza los datos de la cita con los valores proporcionados
                if (citaExistente.isPresent()) {
                    Cita cita = citaExistente.get();
                    cita.setId(citaActualizada.getId());
                    cita.setHora(citaActualizada.getHora());
                    citaRepository.save(cita);
                    return ResponseEntity.ok().body("cita editada correctamente");
                } else {
                    // Si la cita no existe, devuelve un error
                    return ResponseEntity.badRequest().body("La cita no existe"); // Si la cita no existe, retorna 404 Not Found
                }
            }
        } catch (Exception e) { // Si ocurre un error durante la actualización de la cita, lanza una excepción con el mensaje de error correspondiente

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar la cita", e);
        }
    }

    }


