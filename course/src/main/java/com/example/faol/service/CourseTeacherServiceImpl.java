package com.example.faol.service;

import com.example.faol.dto.CourseDTO;
import com.example.faol.mapper.CourseMapper;
import com.example.faol.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseTeacherServiceImpl implements CourseTeacherServiceInt {

    CourseRepository courseRepository;

    public CourseTeacherServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCoursesByTeacherId(Long id) {
        return courseRepository.getAllCoursesByTeacherId(id).stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
