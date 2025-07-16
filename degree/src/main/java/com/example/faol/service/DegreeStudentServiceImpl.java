package com.example.faol.service;

import com.example.faol.models.ResponseWrapper2;
import com.example.faol.models.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class DegreeStudentServiceImpl implements DegreeStudentServiceInt{

    private final RestTemplate restTemplate;

    public DegreeStudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Student> allStudentsByDegreeId(Long degreeId) {
        ResponseEntity<ResponseWrapper2>
                response = restTemplate.exchange(
                "http://localhost:8080/studentDegree/allStudentsByDegreeId/" + degreeId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseWrapper2>() {}
        );
        return response
                .getBody() != null ? response
                .getBody().getList() : Collections
                .emptyList();
    }
}
