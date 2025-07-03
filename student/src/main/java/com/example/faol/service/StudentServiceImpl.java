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

    private RestTemplate restTemplate;

    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
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

    //con este metodo traemos, desde el otro microservicio(Course) todos los cursos que el estudiante tiene:
    @Override
    public List<CourseDTO> allByStudentId(Long studentId){
        try {

            //llamado al controller del microservicio Course:
            ResponseEntity<ResponseWrapper> response = restTemplate.exchange(
                    "http://localhost:8081/course/allByStudentId/" + studentId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ResponseWrapper>() {
                    }
            );
            System.out.println("Response status: " + response.getStatusCode());

            if (response.getBody() == null) {
                System.out.println("Response body is null");
                return Collections.emptyList();
            }

            List<CourseDTO> courses = response.getBody().getCourses();
            System.out.println("Courses received: " + courses);

            return courses;


        }catch (Exception e) {
            System.err.println("Error calling course service: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    @Override
    public List<StudentDTO> getAllStudentsByDegreeId(Long degreeId) {
        return studentRepository.getAllStudentsByDegreeId(degreeId).stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
