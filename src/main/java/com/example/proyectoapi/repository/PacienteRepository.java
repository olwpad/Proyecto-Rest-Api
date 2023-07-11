package com.example.proyectoapi.repository;

import com.example.proyectoapi.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PacienteRepository extends MongoRepository <Paciente, String>{
}
