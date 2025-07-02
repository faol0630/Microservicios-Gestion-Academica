package com.example.faol.service;

import com.example.faol.entity.Course;
import com.example.faol.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseServiceInt{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Course courseToUpdate = courseRepository.findById(id).get();
        courseToUpdate.setCourseName(course.getCourseName());
        courseToUpdate.setCourseDuration(course.getCourseDuration());
        courseToUpdate.setCoursePrice(course.getCoursePrice());
        return courseRepository.save(courseToUpdate);
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
    public List<Course> getAllCoursesByStudentId(Long id) {
        List<Course> courseList = courseRepository.getAllCoursesByStudentId(id);
        return courseList;
    }
}
