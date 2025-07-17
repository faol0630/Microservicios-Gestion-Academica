package com.example.faol.controller;

import com.example.faol.dto.CourseDTO;
import com.example.faol.service.CourseTeacherServiceInt;
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
@RequestMapping("/course/teacher")
public class CourseTeacherController {

    CourseTeacherServiceInt courseTeacherServiceInt;

    public CourseTeacherController(CourseTeacherServiceInt courseTeacherServiceInt) {
        this.courseTeacherServiceInt = courseTeacherServiceInt;
    }

    @GetMapping("/allCoursesByTeacherId/{teacherId}")
    public ResponseEntity<List<CourseDTO>> getAllCoursesByTeacherId(@PathVariable Long teacherId) {
        List<CourseDTO> courses = courseTeacherServiceInt.getAllCoursesByTeacherId(teacherId);
        // Devolvemos la lista directamente. ResponseEntity.ok es un atajo.
        return ResponseEntity.ok(courses);
    }

}
