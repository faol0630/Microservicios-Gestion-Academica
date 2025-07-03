package com.example.faol.service;

import com.example.faol.dto.DegreeDTO;
import com.example.faol.entity.Degree;
import com.example.faol.models.Student;

import java.util.List;

public interface DegreeServiceInt {

    List<DegreeDTO> getAllDegrees();
    DegreeDTO getDegreeById(Long id);
    DegreeDTO saveDegree(Degree degree);
    DegreeDTO updateDegree(Degree degree, Long id);
    void deleteDegreeById(Long id);
    void deleteAllDegrees();
    Long getDegreeCount();
    List<Student> allStudentsByDegreeId(Long degreeId);

}
