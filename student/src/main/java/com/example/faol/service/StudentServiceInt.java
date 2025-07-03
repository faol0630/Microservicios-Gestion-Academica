package com.example.faol.service;

import com.example.faol.Models.CourseDTO;
import com.example.faol.dto.StudentDTO;
import com.example.faol.entity.Student;

import java.util.List;

public interface StudentServiceInt {

    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO saveStudent(Student student);
    StudentDTO updateStudent(Student student, Long id);
    void deleteStudentById(Long id);
    void deleteAllStudents();
    Long getStudentCount();
    List<CourseDTO> allByStudentId(Long studentId);
    List<StudentDTO> getAllStudentsByDegreeId(Long degreeId);
}
