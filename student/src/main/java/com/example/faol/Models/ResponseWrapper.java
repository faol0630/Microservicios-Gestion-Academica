package com.example.faol.Models;

import java.util.List;

public class ResponseWrapper {
    //estos son los 2 elementos que contiene el Map response del metodo:
    // public ResponseEntity<?> getAllCoursesByStudentId(@PathVariable Long id)
    // en el controller del microservicio Course:
    private String message;
    private List<CourseDTO> courses; //esto debe coincidir con la respuesta del microservicio Course
    // (response.put("courses", courses);

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CourseDTO> getCourses() {  // Cambiar getter
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {  // Cambiar setter
        this.courses = courses;
    }

}
