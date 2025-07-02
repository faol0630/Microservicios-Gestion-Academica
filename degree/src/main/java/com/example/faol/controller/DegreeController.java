package com.example.faol.controller;

import com.example.faol.entity.Degree;
import com.example.faol.models.Student;
import com.example.faol.service.DegreeServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/degree")
public class DegreeController {

    DegreeServiceInt degreeService;

    public DegreeController(DegreeServiceInt degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDegrees() {
        Map<String, Object> response = new HashMap<>();
        List<Degree> degreeList = degreeService.getAllDegrees();
        response.put("message", "All degrees retrieved successfully");
        response.put("degrees", degreeList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDegreeById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Degree> degree = degreeService.getDegreeById(id);
        if (degree.isEmpty()) {
            response.put("message", "Degree not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("message", "Degree retrieved successfully");
        response.put("degree", degree.get());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveDegree(@RequestBody Degree degree) {
        Map<String, Object> response = new HashMap<>();
        Degree savedDegree = degreeService.saveDegree(degree);
        response.put("message", "Degree saved successfully");
        response.put("degree", savedDegree);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDegreeById(@PathVariable Long id, @RequestBody Degree degree) {
        Map<String, Object> response = new HashMap<>();
        Degree updatedDegree = degreeService.updateDegree(degree, id);
        if (updatedDegree == null) {
            response.put("message", "Degree not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("message", "Degree updated successfully");
        response.put("degree", updatedDegree);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDegreeById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        degreeService.deleteDegreeById(id);
        response.put("message", "Degree deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllDegrees() {
        Map<String, Object> response = new HashMap<>();
        degreeService.deleteAllDegrees();
        response.put("message", "All degrees deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
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
