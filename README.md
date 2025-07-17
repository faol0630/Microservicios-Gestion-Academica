
# Microservicios Gestión Académica 

## Descripción
Sistema de gestión académica implementado con arquitectura de microservicios utilizando Spring Boot. El sistema permite gestionar estudiantes, profesores, cursos y grados académicos, proporcionando una API REST para cada uno de estos servicios.

## Microservicios
El proyecto está compuesto por tres microservicios principales:

1. **Servicio de Estudiantes**
   - Gestión de información básica de estudiantes
   - CRUD operaciones para estudiantes
   - Endpoints en `/student`

2. **Servicio de Cursos**
   - Gestión de cursos y asignaciones de estudiantes
   - Relaciona estudiantes con sus cursos
   - Endpoints en `/studentCourse`

3. **Servicio de Grados**
   - Gestión de grados académicos
   - Permite consultar estudiantes por grado
   - Endpoints en `/studentDegree`

4. **Servicio de Profesores**
   - Gestión de información básica de profesores 
   - CRUD operaciones para profesores

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3.3.13
- Spring Data JPA
- MySQL
- Maven
- Swagger/OpenAPI 2.3.0 (springdoc-openapi)
- Spring Validation

## Requisitos Previos
- JDK 17 o superior
- Maven 3.6 o superior
- MySQL 8.0 o superior
- IDE (recomendado: IntelliJ IDEA)

## Configuración del Proyecto

### Base de Datos
El proyecto utiliza MySQL como base de datos.

### Pasos de Instalación
1. Clonar el repositorio:
```bash
git clone https://github.com/faol0630/Microservicios-Gestion-Academica.git
cd microservicios_basico
```

2. Compilar el proyecto:
```bash
mvn clean install
```

3. Ejecutar cada microservicio:
```bash
cd [directorio-microservicio]
mvn spring-boot:run
```

## Documentación API

### Endpoints Principales

#### Servicio de Estudiantes
- GET `/student` - Obtener todos los estudiantes
- GET `/student/{id}` - Obtener estudiante por ID
- POST `/student` - Crear nuevo estudiante
- PUT `/student/{id}` - Actualizar estudiante
- DELETE `/student/{id}` - Eliminar estudiante

#### Servicio de Cursos
- GET `/studentCourse` - Obtener todos los cursos
- GET `/studentCourse/students/{courseId}` - Obtener estudiantes por curso

#### Servicio de Grados
- GET `/studentDegree/allStudentsByDegreeId/{degreeId}` - Obtener estudiantes por grado

## Documentación Swagger
La documentación detallada de la API está disponible a través de Swagger UI:

- http://localhost:8080/swagger-ui.html
- http://localhost:8081/swagger-ui.html
- http://localhost:8082/swagger-ui.html
- http://localhost:8083/swagger-ui.html


## Contacto
Francisco Ocoro L - franciscoocoro@gmail.com

Link del proyecto: https://github.com/faol0630/Microservicios-Gestion-Academica.git

