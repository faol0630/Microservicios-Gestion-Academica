package com.example.faol.controller;

import com.example.faol.dto.StudentDTO;
import com.example.faol.entity.Student;
import com.example.faol.service.StudentServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
