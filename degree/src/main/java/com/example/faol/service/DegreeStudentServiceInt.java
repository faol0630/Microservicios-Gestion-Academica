package com.example.faol.service;

import com.example.faol.models.Student;

import java.util.List;

public interface DegreeStudentServiceInt {

    List<Student> allStudentsByDegreeId(Long degreeId);
}
