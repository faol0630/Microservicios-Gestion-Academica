package com.faol.demo.controller;

import com.faol.demo.models.CourseDTO;
import com.faol.demo.service.TeacherCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher/course")
public class TeacherCourseController {

    TeacherCourseService teacherCourseService;

    public TeacherCourseController(TeacherCourseService teacherCourseService) {
        this.teacherCourseService = teacherCourseService;
    }

    @GetMapping("/getAllCoursesByTeacherId/{teacherId}")
    public ResponseEntity<List<CourseDTO>> getAllCoursesByTeacherId(@PathVariable Long teacherId){
        List<CourseDTO> courses = teacherCourseService.getAllCoursesByTeacherId(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
}
