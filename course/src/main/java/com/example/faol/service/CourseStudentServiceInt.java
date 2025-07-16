package com.example.faol.service;

import com.example.faol.dto.CourseDTO;

import java.util.List;

public interface CourseStudentServiceInt {

    List<CourseDTO> getAllCoursesByStudentId(Long id);
}
