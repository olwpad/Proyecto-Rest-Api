package com.example.proyectoapi.repository;

import com.example.proyectoapi.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository <Doctor, String> {


}
