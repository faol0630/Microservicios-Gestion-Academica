package com.example.faol.controller;

import com.example.faol.dto.CourseDTO;
import com.example.faol.service.CourseStudentServiceInt;
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
@RequestMapping("/course/rest")
public class CourseStudentController {

    private final CourseStudentServiceInt courseStudentServiceInt;

    public CourseStudentController(CourseStudentServiceInt courseStudentServiceInt) {
        this.courseStudentServiceInt = courseStudentServiceInt;
    }

    @GetMapping("/allByStudentId/{id}")
    public ResponseEntity<?> getAllCoursesByStudentId(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        List<CourseDTO> courses = courseStudentServiceInt.getAllCoursesByStudentId(id);
        response.put("message", "All DTO courses by student ID retrieved successfully");
        response.put("courses", courses);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
