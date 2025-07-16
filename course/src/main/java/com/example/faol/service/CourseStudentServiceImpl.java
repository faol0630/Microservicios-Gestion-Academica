package com.example.faol.service;

import com.example.faol.dto.CourseDTO;
import com.example.faol.mapper.CourseMapper;
import com.example.faol.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseStudentServiceImpl implements CourseStudentServiceInt {

    private final CourseRepository courseRepository;

    public CourseStudentServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCoursesByStudentId(Long id) {
        return courseRepository.getAllCoursesByStudentId(id).stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
