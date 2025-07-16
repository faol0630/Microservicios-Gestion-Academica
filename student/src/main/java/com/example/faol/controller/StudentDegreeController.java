package com.example.faol.controller;

import com.example.faol.dto.StudentDTO;
import com.example.faol.service.StudentDegreeServiceInt;
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
@RequestMapping("/studentDegree")
public class StudentDegreeController {

    private final StudentDegreeServiceInt studentService;

    public StudentDegreeController(StudentDegreeServiceInt studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allStudentsByDegreeId/{degreeId}")
    public ResponseEntity<?> getAllStudentsByDegreeId(@PathVariable Long degreeId){
        Map<String, Object> response = new HashMap<>();
        List<StudentDTO> allStudentsByDegreeId = studentService.getAllStudentsByDegreeId(degreeId);
        response.put("message", "All students by degreeId retrieved successfully");
        response.put("list", allStudentsByDegreeId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
