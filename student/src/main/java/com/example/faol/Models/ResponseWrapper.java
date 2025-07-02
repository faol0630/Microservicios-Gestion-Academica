package com.example.faol.Models;

import java.util.List;

public class ResponseWrapper {
    //estos son los 2 elementos que contiene el Map response del metodo:
    // public ResponseEntity<?> getAllCoursesByStudentId(@PathVariable Long id)
    // en el controller del microservicio Course:
    private String message;
    private List<Course> courses; //esto debe coincidir con la respuesta del micro servicio Course
    // (response.put("courses", courses);

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Course> getCourses() {  // Cambiar getter
        return courses;
    }

    public void setCourses(List<Course> courses) {  // Cambiar setter
        this.courses = courses;
    }

}
