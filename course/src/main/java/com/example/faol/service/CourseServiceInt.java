package com.example.faol.service;

import com.example.faol.dto.CourseDTO;
import com.example.faol.entity.Course;

import java.util.List;

public interface CourseServiceInt {

    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO saveCourse(Course course);
    CourseDTO updateCourse(Course course, Long id);
    void deleteCourseById(Long id);
    void deleteAllCourses();
    Long getCourseCount();
    List<CourseDTO> getAllCoursesByStudentId(Long id);
}
