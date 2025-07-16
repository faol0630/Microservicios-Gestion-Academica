package com.example.faol.controller;

import com.example.faol.dto.CourseDTO;
import com.example.faol.entity.Course;
import com.example.faol.service.CourseServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceInt courseServiceInt;

    public CourseController(CourseServiceInt courseService) {
        this.courseServiceInt = courseService;
    }

    @GetMapping("/all")
    public List<CourseDTO> getAllCourses() {
        return courseServiceInt.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseServiceInt.getCourseById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO saveCourse(@RequestBody Course course) {
        return courseServiceInt.saveCourse(course);
    }

    @PutMapping("/update/{id}")
    public CourseDTO updateCourse(@RequestBody Course course, @PathVariable Long id) {
        return courseServiceInt.updateCourse(course, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourseById(@PathVariable Long id) {
        courseServiceInt.deleteCourseById(id);
    }

    @DeleteMapping("/deleteAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCourses() {
        courseServiceInt.deleteAllCourses();
    }

    @GetMapping("/count")
    public Long getCourseCount() {
        return courseServiceInt.getCourseCount();
    }


}
