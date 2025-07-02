package com.example.faol.service;

import com.example.faol.Models.Course;
import com.example.faol.Models.ResponseWrapper;
import com.example.faol.entity.Student;
import com.example.faol.repository.StudentRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServiceInt{

    private final StudentRepository studentRepository;

    private RestTemplate restTemplate;

    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student studentToUpdate = studentRepository.findById(id).get();
        studentToUpdate.setName(student.getName());
        studentToUpdate.setLastname(student.getLastname());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setPhone_number(student.getPhone_number());
        studentToUpdate.setDegreeId(student.getDegreeId());
        return studentRepository.save(studentToUpdate);
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
    public List<Course> allByStudentId(Long studentId){
        //llamado al controller del microservicio Course:
        ResponseEntity<ResponseWrapper>
                response = restTemplate.exchange(
                "http://localhost:8081/course/allByStudentId/" + studentId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseWrapper>() {}
        );
        return response.getBody() != null ? response.getBody().getCourses() : Collections.emptyList();

    }

    @Override
    public List<Student> getAllStudentsByDegreeId(Long degreeId) {
        return studentRepository.getAllStudentsByDegreeId(degreeId);
    }


}
