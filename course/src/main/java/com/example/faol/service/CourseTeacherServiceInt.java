package com.example.faol.service;

import com.example.faol.dto.CourseDTO;

import java.util.List;

public interface CourseTeacherServiceInt {

    List<CourseDTO> getAllCoursesByTeacherId(Long id);
}
