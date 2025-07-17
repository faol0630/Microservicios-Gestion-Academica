package com.example.faol.mapper;

import com.example.faol.dto.CourseDTO;
import com.example.faol.entity.Course;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseDuration(course.getCourseDuration());
        courseDTO.setCoursePrice(course.getCoursePrice());
        courseDTO.setStudentId(course.getStudentId());
        courseDTO.setTeacherId(course.getTeacherId());
        return courseDTO;
    }

    public static Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseId(courseDTO.getCourseId());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseDuration(courseDTO.getCourseDuration());
        course.setCoursePrice(courseDTO.getCoursePrice());
        course.setStudentId(courseDTO.getStudentId());
        course.setTeacherId(courseDTO.getTeacherId());
        return course;
    }
}
