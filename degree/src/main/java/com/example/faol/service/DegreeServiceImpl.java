package com.example.faol.service;

import com.example.faol.dto.DegreeDTO;
import com.example.faol.entity.Degree;
import com.example.faol.exception.ResourceNotFoundException;
import com.example.faol.mapper.DegreeMapper;
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
import java.util.stream.Collectors;

@Service
public class DegreeServiceImpl implements DegreeServiceInt {

    private final DegreeRepository degreeRepository;
    private final RestTemplate restTemplate;

    public DegreeServiceImpl(DegreeRepository degreeRepository, RestTemplate restTemplate) {
        this.degreeRepository = degreeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DegreeDTO> getAllDegrees() {
        return degreeRepository.findAll().stream()
                .map(DegreeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DegreeDTO getDegreeById(Long id) {
        Degree degree = degreeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Degree not found with id: " + id));
        return DegreeMapper.toDTO(degree);
    }

    @Override
    public DegreeDTO saveDegree(Degree degree) {
        Degree savedDegree = degreeRepository.save(degree);
        return DegreeMapper.toDTO(savedDegree);
    }

    @Override
    public DegreeDTO updateDegree(Degree degree, Long id) {
        Degree degreeToUpdate = degreeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Degree not found with id: " + id));
        degreeToUpdate.setName(degree.getName());
        degreeToUpdate.setDuration(degree.getDuration());
        degreeToUpdate.setTotal_cost(degree.getTotal_cost());
        Degree updatedDegree = degreeRepository.save(degreeToUpdate);
        return DegreeMapper.toDTO(updatedDegree);
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
