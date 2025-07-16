package com.example.faol.controller;

import com.example.faol.Models.CourseDTO;
import com.example.faol.exception.ResourceNotFoundException;
import com.example.faol.service.StudentCourseServiceInt;
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
@RequestMapping("/studentCourse")
public class StudentCourseController {

    private final StudentCourseServiceInt studentService;

    public StudentCourseController(StudentCourseServiceInt studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allCoursesByStudentId/{studentId}")
    public ResponseEntity<?> allByStudentId(@PathVariable Long studentId){
        Map<String, Object> response = new HashMap<>();
        try {

            List<CourseDTO> courses = studentService.allByStudentId(studentId);

            if (courses == null) {
                response.put("message", "Null student list with id: " + studentId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            } else if (courses.isEmpty()) {
                response.put("message", "No courses found for studentId: " + studentId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            }
            response.put("message", "All courses by studentId retrieved successfully");
            response.put("courses", courses                                                                                            );
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }catch (ResourceNotFoundException e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception e) {
            response.put("message", "Error while retrieving courses");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
