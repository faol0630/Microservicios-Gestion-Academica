package com.example.faol.controller;

import com.example.faol.Models.CourseDTO;
import com.example.faol.dto.StudentDTO;
import com.example.faol.entity.Student;
import com.example.faol.exception.ResourceNotFoundException;
import com.example.faol.service.StudentServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceInt studentService;

    public StudentController(StudentServiceInt studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/update/{id}")
    public StudentDTO updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }

    @GetMapping("/count")
    public Long getStudentCount(){
        return studentService.getStudentCount();
    }

    //este metodo se debe corregir
    //este metodo se debe corregir
    //este metodo se debe corregir
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

    @GetMapping("/allStudentsByDegreeId/{degreeId}")
    public ResponseEntity<?> getAllStudentsByDegreeId(@PathVariable Long degreeId){
        Map<String, Object> response = new HashMap<>();
        List<StudentDTO> allStudentsByDegreeId = studentService.getAllStudentsByDegreeId(degreeId);
        response.put("message", "All students by degreeId retrieved successfully");
        response.put("list", allStudentsByDegreeId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
