package com.example.faol.service;

import com.example.faol.Models.CourseDTO;

import java.util.List;

public interface StudentCourseServiceInt {

    List<CourseDTO> allByStudentId(Long studentId);
}
