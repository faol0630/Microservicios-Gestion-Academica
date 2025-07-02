package com.example.faol.repository;

import com.example.faol.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findStudentByName(String name);
    public List<Student> getAllStudentsByDegreeId(Long degreeId);

}
