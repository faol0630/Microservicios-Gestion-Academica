package com.example.faol.controller;

import com.example.faol.Models.Course;
import com.example.faol.entity.Student;
import com.example.faol.service.StudentServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentServiceInt studentService;

    public StudentController(StudentServiceInt studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents(){
        Map<String, Object> response = new HashMap<>();
        List<Student> students = studentService.getAllStudents();
        response.put("message", "All students retrieved successfully");
        response.put("students", students);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Optional<Student> student = studentService.getStudentById(id);
        response.put("message", "Student retrieved successfully");
        response.put("student", student);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        Map<String, Object> response = new HashMap<>();
        Student savedStudent = studentService.saveStudent(student);
        response.put("message", "Student saved successfully");
        response.put("student", savedStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Student updatedStudent = studentService.updateStudent(student, id);
        response.put("message", "Student updated successfully");
        response.put("student", updatedStudent);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        studentService.deleteStudentById(id);
        response.put("message", "Student deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllStudents(){
        Map<String, Object> response = new HashMap<>();
        studentService.deleteAllStudents();
        response.put("message", "All students deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getStudentCount(){
        Map<String, Object> response = new HashMap<>();
        Long studentCount = studentService.getStudentCount();
        response.put("message", "Student count retrieved successfully");
        response.put("studentCount", studentCount);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/allByStudentId/{studentId}")
    public ResponseEntity<?> allByStudentId(@PathVariable Long studentId){
        Map<String, Object> response = new HashMap<>();
        List<Course> allCourseListByStudenttId = studentService.allByStudentId(studentId);
        response.put("message", "All courses by studentId retrieved successfully");
        response.put("list", allCourseListByStudenttId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/allStudentsByDegreeId/{degreeId}")
    public ResponseEntity<?> getAllStudentsByDegreeId(@PathVariable Long degreeId){
        Map<String, Object> response = new HashMap<>();
        List<Student> allStudentsByDegreeId = studentService.getAllStudentsByDegreeId(degreeId);
        response.put("message", "All students by degreeId retrieved successfully");
        response.put("list", allStudentsByDegreeId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
