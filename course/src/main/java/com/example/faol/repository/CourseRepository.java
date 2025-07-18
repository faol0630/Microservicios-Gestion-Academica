package com.example.faol.repository;

import com.example.faol.dto.CourseDTO;
import com.example.faol.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> getAllCoursesByStudentId(Long id);
    List<Course> getAllCoursesByTeacherId(Long id);

}
