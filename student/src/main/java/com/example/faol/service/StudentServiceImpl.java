package com.example.faol.service;

import com.example.faol.Models.CourseDTO;
import com.example.faol.Models.ResponseWrapper;
import com.example.faol.dto.StudentDTO;
import com.example.faol.entity.Student;
import com.example.faol.exception.ResourceNotFoundException;
import com.example.faol.mapper.StudentMapper;
import com.example.faol.repository.StudentRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServiceInt{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return StudentMapper.toDTO(student);
    }

    @Override
    public StudentDTO saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Student student, Long id) {
        Student studentToUpdate = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentToUpdate.setName(student.getName());
        studentToUpdate.setLastname(student.getLastname());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setPhone_number(student.getPhone_number());
        studentToUpdate.setDegreeId(student.getDegreeId());
        Student updatedStudent = studentRepository.save(studentToUpdate);
        return StudentMapper.toDTO(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public Long getStudentCount() {
        return studentRepository.count();
    }


}
