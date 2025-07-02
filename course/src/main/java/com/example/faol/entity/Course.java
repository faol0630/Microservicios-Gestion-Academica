package com.example.faol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name")
    @NotNull(message = "Course name cannot be null")
    private String courseName;

    @Column(name = "course_duration")
    @NotNull(message = "Course duration cannot be null")
    private String courseDuration;

    @Column(name = "course_price")
    @NotNull(message = "Course price cannot be null")
    private Double coursePrice;

    @Column(name = "student_id")
    @NotNull(message = "Student ID cannot be null")
    private Long studentId;

    public Course() {
    }

    public Course(String courseName, String courseDuration, Double coursePrice, Long studentId) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.coursePrice = coursePrice;
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration=" + courseDuration +
                ", coursePrice=" + coursePrice +
                ", studentId=" + studentId +
                '}';
    }
}
