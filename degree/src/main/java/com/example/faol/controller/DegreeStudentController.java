package com.example.faol.controller;

import com.example.faol.models.Student;
import com.example.faol.service.DegreeStudentServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/degreeStudent")
public class DegreeStudentController {

    private final DegreeStudentServiceInt degreeService;

    public DegreeStudentController(DegreeStudentServiceInt degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping("/allStudentsByDegreeId/{degreeId}")
    public ResponseEntity<?> allStudentsByDegreeId(@PathVariable Long degreeId) {
        Map<String, Object> response = new HashMap<>();
        List<Student> studentList = degreeService.allStudentsByDegreeId(degreeId);
        response.put("message", "All students by degreeId retrieved successfully");
        response.put("students", studentList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
