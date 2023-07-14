package com.example.proyectoapi.repository;

import com.example.proyectoapi.model.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CitaRepository extends MongoRepository<Cita, String> {

    boolean existsByCedulaDoctor(String id);

    boolean existsBynumeroDeCedula(String id);
}
