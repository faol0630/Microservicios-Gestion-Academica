package com.example.faol.service;

import com.example.faol.entity.Degree;
import com.example.faol.models.Student;

import java.util.List;
import java.util.Optional;

public interface DegreeServiceInt {

    List<Degree> getAllDegrees();
    Optional<Degree> getDegreeById(Long id);
    Degree saveDegree(Degree degree);
    Degree updateDegree(Degree degree, Long id);
    void deleteDegreeById(Long id);
    void deleteAllDegrees();
    Long getDegreeCount();
    List<Student> allStudentsByDegreeId(Long degreeId);

}
