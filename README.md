# Proyecto-Rest-Api

Este proyecto está diseñado para fortalecer los conocimientos en API REST. Permite el registro de pacientes, doctores y citas, así como la posibilidad de editar y eliminar dichos registros. :clipboard:

## Funcionalidad

Este proyecto está diseñado para cumplir con el concepto Rest-Api:

1. :x: **Elimina**: Paciente, Doctores y Citas.
2. :pencil2: **Edita**: Paciente, Doctores y Citas.
3. :mag: **Busca**: Paciente, Doctores y Citas.
4. :heavy_plus_sign: **Agrega**: Paciente, Doctores y Citas.


## Tecnologías Utilizadas
El proyecto hace uso de las siguientes tecnologías y herramientas:
- :coffee: **Java**: Un lenguaje de programación de propósito general y orientado a objetos.
- :computer: **Spring Boot**: Un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones empresariales.
  - Dependencias utilizadas:
    - org.springframework.boot:spring-boot-starter-data-mongodb
    - org.springframework.boot:spring-boot-starter-web
    - org.springframework.boot:spring-boot-devtools
    - org.springframework.boot:spring-boot-starter-tomcat
    - org.springframework.boot:spring-boot-starter-test
- :floppy_disk: **MongoDB**: Una base de datos NoSQL de alto rendimiento y de código abierto.
- :link: **Postman**: Una plataforma de colaboración para el desarrollo de API que permite probar, documentar y compartir fácilmente las API creadas.
- :wrench: **Lombok**: Una biblioteca de Java que agiliza el desarrollo eliminando la necesidad de escribir código repetitivo, como getters, setters y constructores.


  

## Endpoints
A continuación se muestran los endpoints disponibles en esta API, junto con las acciones asociadas a cada uno. Tenga en cuenta que los verbos HTTP (POST, GET, DELETE, PUT) se mencionan para indicar las acciones correspondientes a cada endpoint, pero deben eliminarse al utilizarlos:`.

### Citas :calendar:
- `POST /api/v1/citas`: Crea una nueva cita en la base de datos.
- `GET /api/v1/citas`: Obtiene todas las citas registradas en la base de datos.
- `GET /api/v1/cita/{id}`: Obtiene los datos de una cita específica según su ID.
- `DELETE /api/v1/cita/{id}`: Elimina una cita específica de la base de datos según su ID.
- `PUT /api/v1/citas`: Actualiza los datos de una cita específica en la base de datos.
### Doctores :man_health_worker:
- `POST /api/v1/doctores`: Crea un nuevo doctor en la base de datos.
- `GET /api/v1/doctores`: Obtiene todos los doctores registrados en la base de datos.
- `GET /api/v1/doctor/{id}`: Obtiene los datos de un doctor específico según su ID.
- `DELETE /api/v1/doctor/{id}`: Elimina un doctor específico de la base de datos según su ID.
- `PUT /api/v1/doctores`: Actualiza los datos de un doctor específico en la base de datos.
### Pacientes :woman_health_worker:
- `POST /api/v1/pacientes`: Crea un nuevo paciente en la base de datos.
- `GET /api/v1/pacientes`: Obtiene todos los pacientes registrados en la base de datos.
- `GET /api/v1/paciente/{id}`: Obtiene los datos de un paciente específico según su ID.
- `DELETE /api/v1/paciente/{id}`: Elimina un paciente específico de la base de datos según su ID.
- `PUT /api/v1/pacientes`: Actualiza los datos de un paciente específico en la base de datos.
  
Recuerda reemplazar `{id}` en los endpoints que lo requieren con el ID correspondiente.

## Pruebas 
[:bulb: Prueba del proyecto](https://github.com/olwpad/Proyecto-Rest-Api)

## Configuración

A continuación, se detallan los pasos para configurar y ejecutar el proyecto en tu entorno local:

1.:open_file_folder: Clona el repositorio desde [https://github.com/olwpad/Proyecto-Eps-Rest-Api.git](https://github.com/olwpad/Proyecto-Eps-Rest-Api.git).








