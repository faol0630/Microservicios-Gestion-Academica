package com.faol.demo.service;

import com.faol.demo.feign_client.CourseFeignClient;
import com.faol.demo.models.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseService {

    CourseFeignClient courseFeignClient;

    public TeacherCourseService(CourseFeignClient courseFeignClient) {
        this.courseFeignClient = courseFeignClient;
    }

    public List<CourseDTO> getAllCoursesByTeacherId(Long teacherId){
        List<CourseDTO> courses = courseFeignClient.getAllCoursesByTeacherId(teacherId);
        return courses;
    }

}
