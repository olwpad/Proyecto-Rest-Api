package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Doctor;
import com.example.proyectoapi.repository.CitaRepository;
import com.example.proyectoapi.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final CitaRepository citaRepository;
        public ResponseEntity<?> save(Doctor doctor) {
            try {
                boolean doctorExists = doctorRepository.existsById(doctor.getId());
                if (doctorExists) {
                    return ResponseEntity.badRequest().body("El DOCTOR YA ESTÁ REGISTRADO");
                } else {
                    doctorRepository.save(doctor);
                    return ResponseEntity.ok().build();
                }

            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el doctor", e);
            }
        }

        // ...


    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(String id) {
        return  doctorRepository.findById(id);
    }

    public ResponseEntity deleteById(String id) {

            try{
              boolean doctorexistencita=citaRepository.existsByCedulaDoctor(id);
              if (doctorexistencita) {
                    return ResponseEntity.badRequest().body("No puedes borrar doctor porque tiene citas pendientes");
                } else {
                    doctorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }

            }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el doctor", e);
        }

    }
    public ResponseEntity<?> update(Doctor doctor) {
        try {
            boolean doctorexiste = doctorRepository.existsById(doctor.getId());
            if (!doctorexiste) {
                return ResponseEntity.badRequest().body("No puedes editar doctor porque no existe");
            } else {
                // Obtener el doctor existente de la base de datos
                Doctor doctorExistente = doctorRepository.findById(doctor.getId()).orElse(null);
                if (doctorExistente != null) {
                    // Establecer los nuevos valores en el doctor existente
                    doctorExistente.setConsultorio(doctor.getConsultorio());
                    doctorExistente.setEspecialidad(doctor.getEspecialidad());
                    doctorExistente.setEmail(doctor.getEmail());
                    doctorRepository.save(doctorExistente);
                } else {
                    return ResponseEntity.badRequest().body("El doctor no existe");
                }
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar al paciente", e);
        }
    }

}
