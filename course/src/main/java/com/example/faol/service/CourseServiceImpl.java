package com.example.faol.service;

import com.example.faol.dto.CourseDTO;
import com.example.faol.entity.Course;
import com.example.faol.exception.ResourceNotFoundException;
import com.example.faol.mapper.CourseMapper;
import com.example.faol.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseServiceInt{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return CourseMapper.toDTO(course);
    }

    @Override
    public CourseDTO saveCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(Course course, Long id) {
        Course courseToUpdate = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        courseToUpdate.setCourseName(course.getCourseName());
        courseToUpdate.setCourseDuration(course.getCourseDuration());
        courseToUpdate.setCoursePrice(course.getCoursePrice());
        courseToUpdate.setStudentId(course.getStudentId());
        Course updatedCourse = courseRepository.save(courseToUpdate);
        return CourseMapper.toDTO(updatedCourse);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

    @Override
    public Long getCourseCount() {
       return courseRepository.count();
    }

    @Override
    public List<CourseDTO> getAllCoursesByStudentId(Long id) {
        return courseRepository.getAllCoursesByStudentId(id).stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
