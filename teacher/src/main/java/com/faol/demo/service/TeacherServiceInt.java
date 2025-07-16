package com.faol.demo.service;

import com.faol.demo.dto.TeacherDTO;
import com.faol.demo.entity.Teacher;

import java.util.List;

public interface TeacherServiceInt {

    List<TeacherDTO> getAllTeachers();
    TeacherDTO getTeacherById(Long id);
    TeacherDTO saveTeacher(Teacher teacher);
    TeacherDTO updateTeacher(Teacher teacher, Long id);
    void deleteTeacherById(Long id);
    void deleteAllTeachers();
    Long getTeacherCount();
}
