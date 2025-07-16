package com.example.faol.service;

import com.example.faol.Models.CourseDTO;
import com.example.faol.Models.ResponseWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseServiceInt{

    private RestTemplate restTemplate;

    public StudentCourseServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //con este metodo traemos, desde el otro microservicio(Course) todos los cursos que el estudiante tiene:
    @Override
    public List<CourseDTO> allByStudentId(Long studentId){
        try {

            //llamado al controller del microservicio Course:
            ResponseEntity<ResponseWrapper> response = restTemplate.exchange(
                    "http://localhost:8081/course/rest/allByStudentId/" + studentId,
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
}
