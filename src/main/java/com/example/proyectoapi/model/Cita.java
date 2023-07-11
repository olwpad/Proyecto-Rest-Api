package com.example.proyectoapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "cita")
@Data
public class Cita {
    @Id
    private String id;
    private  String especialidad;
    private String cedulaDoctor;
    private String numeroDeCedula;
    private String hora;
}