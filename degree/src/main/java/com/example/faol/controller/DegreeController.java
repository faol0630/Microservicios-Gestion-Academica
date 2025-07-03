package com.example.faol.controller;

import com.example.faol.dto.DegreeDTO;
import com.example.faol.entity.Degree;
import com.example.faol.models.Student;
import com.example.faol.service.DegreeServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/degree")
public class DegreeController {

    private final DegreeServiceInt degreeService;

    public DegreeController(DegreeServiceInt degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping("/all")
    public List<DegreeDTO> getAllDegrees() {
        return degreeService.getAllDegrees();
    }

    @GetMapping("/{id}")
    public DegreeDTO getDegreeById(@PathVariable Long id) {
        return degreeService.getDegreeById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public DegreeDTO saveDegree(@RequestBody Degree degree) {
        return degreeService.saveDegree(degree);
    }

    @PutMapping("/{id}")
    public DegreeDTO updateDegreeById(@PathVariable Long id, @RequestBody Degree degree) {
        return degreeService.updateDegree(degree, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDegreeById(@PathVariable Long id) {
        degreeService.deleteDegreeById(id);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllDegrees() {
        degreeService.deleteAllDegrees();
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
