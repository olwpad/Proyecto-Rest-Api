package com.example.proyectoapi.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "Paciente")
@Data// Crea getters y setters
public class Paciente{
    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String email;
    private Integer edad;
    private String telefono;

}
