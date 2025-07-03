package com.example.faol.mapper;

import com.example.faol.dto.StudentDTO;
import com.example.faol.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhone_number(student.getPhone_number());
        studentDTO.setDegreeId(student.getDegreeId());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setName(studentDTO.getName());
        student.setLastname(studentDTO.getLastname());
        student.setEmail(studentDTO.getEmail());
        student.setPhone_number(studentDTO.getPhone_number());
        student.setDegreeId(studentDTO.getDegreeId());
        return student;
    }
}
