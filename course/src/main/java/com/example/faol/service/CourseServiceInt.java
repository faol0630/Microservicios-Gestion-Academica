package com.example.faol.service;

import com.example.faol.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInt {

    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course saveCourse(Course course);
    Course updateCourse(Course course, Long id);
    void deleteCourseById(Long id);
    void deleteAllCourses();
    Long getCourseCount();
    List<Course> getAllCoursesByStudentId(Long id);
}
