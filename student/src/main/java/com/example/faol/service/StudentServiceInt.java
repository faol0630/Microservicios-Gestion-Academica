package com.example.faol.service;

import com.example.faol.Models.Course;
import com.example.faol.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInt {

    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Student student, Long id);
    void deleteStudentById(Long id);
    void deleteAllStudents();
    Long getStudentCount();
    List<Course> allByStudentId(Long studentId);
    List<Student> getAllStudentsByDegreeId(Long degreeId);
}
