package com.example.faol.controller;

import com.example.faol.entity.Course;
import com.example.faol.service.CourseServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseServiceInt courseServiceInt;

    public CourseController(CourseServiceInt courseService) {
        this.courseServiceInt = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses() {
        Map<String, Object> response = new HashMap<>();
        List<Course> courses = courseServiceInt.getAllCourses();
        response.put("message", "All courses retrieved successfully");
        response.put("courses", courses);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Course> course = courseServiceInt.getCourseById(id);
        response.put("message", "Course retrieved successfully");
        response.put("course", course);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {
        Map<String, Object> response = new HashMap<>();
        Course savedCourse = courseServiceInt.saveCourse(course);
        response.put("message", "Course saved successfully");
        response.put("course", savedCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Course updatedCourse = courseServiceInt.updateCourse(course, id);
        response.put("message", "Course updated successfully");
        response.put("course", updatedCourse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        courseServiceInt.deleteCourseById(id);
        response.put("message", "Course deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCourses() {
        Map<String, Object> response = new HashMap<>();
        courseServiceInt.deleteAllCourses();
        response.put("message", "All courses deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCourseCount() {
        Map<String, Object> response = new HashMap<>();
        Long count = courseServiceInt.getCourseCount();
        response.put("message", "Course count retrieved successfully");
        response.put("count", count);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/allByStudentId/{id}")
    public ResponseEntity<?> getAllCoursesByStudentId(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        List<Course> courses = courseServiceInt.getAllCoursesByStudentId(id);
        response.put("message", "All courses by student ID retrieved successfully");
        response.put("courses", courses);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
