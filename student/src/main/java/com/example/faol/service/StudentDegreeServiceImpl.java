package com.example.faol.service;

import com.example.faol.dto.StudentDTO;
import com.example.faol.mapper.StudentMapper;
import com.example.faol.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentDegreeServiceImpl implements StudentDegreeServiceInt{

    private final StudentRepository studentRepository;

    public StudentDegreeServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudentsByDegreeId(Long degreeId) {
        return studentRepository.getAllStudentsByDegreeId(degreeId).stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
