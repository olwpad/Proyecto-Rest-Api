package com.example.proyectoapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Doctor")
@Data
public class Doctor {
    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String numeroDeCedula;
    private String especialidad;
    private String consultorio;
    private String email;
}