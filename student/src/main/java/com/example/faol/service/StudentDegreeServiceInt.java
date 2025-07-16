package com.example.faol.service;

import com.example.faol.dto.StudentDTO;

import java.util.List;

public interface StudentDegreeServiceInt {

    List<StudentDTO> getAllStudentsByDegreeId(Long degreeId);
}
