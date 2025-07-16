package com.faol.demo.mapper;

import com.faol.demo.dto.TeacherDTO;
import com.faol.demo.entity.Teacher;

public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher) {

        if (teacher == null) {
            return null;
        }
        return new TeacherDTO(
                teacher.getName(),
                teacher.getLastname(),
                teacher.getEmail(),
                teacher.getPhoneNumber()
        );
    }
}
