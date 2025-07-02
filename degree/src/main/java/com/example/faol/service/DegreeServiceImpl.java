package com.example.faol.service;

import com.example.faol.entity.Degree;
import com.example.faol.models.ResponseWrapper2;
import com.example.faol.models.Student;
import com.example.faol.repository.DegreeRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DegreeServiceImpl implements DegreeServiceInt {

    DegreeRepository degreeRepository;
    RestTemplate restTemplate;

    public DegreeServiceImpl(DegreeRepository degreeRepository, RestTemplate restTemplate) {
        this.degreeRepository = degreeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    @Override
    public Optional<Degree> getDegreeById(Long id) {
        return degreeRepository.findById(id);
    }

    @Override
    public Degree saveDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    @Override
    public Degree updateDegree(Degree degree, Long id) {
        Optional<Degree> degreeToUpdate = degreeRepository.findById(id);
        Degree updatedDegree = new Degree();
        if (degreeToUpdate.isPresent()) {
            updatedDegree = degreeToUpdate.get();
            updatedDegree.setName(degree.getName());
            updatedDegree.setDuration(degree.getDuration());
            updatedDegree.setTotal_cost(degree.getTotal_cost());
        }
        return degreeRepository.save(updatedDegree);
    }

    @Override
    public void deleteDegreeById(Long id) {
        degreeRepository.deleteById(id);
    }

    @Override
    public void deleteAllDegrees() {
        degreeRepository.deleteAll();
    }

    @Override
    public Long getDegreeCount() {
        return degreeRepository.count();
    }

    @Override
    public List<Student> allStudentsByDegreeId(Long degreeId) {
        ResponseEntity<ResponseWrapper2>
                response = restTemplate.exchange(
                "http://localhost:8080/student/allStudentsByDegreeId/" + degreeId,
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
