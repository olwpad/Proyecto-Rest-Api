package com.example.proyectoapi.service;

import com.example.proyectoapi.model.Doctor;
import com.example.proyectoapi.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    public void save (Doctor doctor){
        doctorRepository.save(doctor);

    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(String id) {
        return  doctorRepository.findById(id);
    }

    public void deleteById(String id) {
        doctorRepository.deleteById(id);
    }

}
