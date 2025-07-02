package com.example.faol.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "lastname")
    @NotNull(message = "Lastname cannot be null")
    private String lastname;

    @Column(name = "email")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    private String email;

    @Column(name = "phone_number", unique = true)
    @NotNull(message = "Phone number cannot be null")
    private String phone_number;

    @Column(name = "degree_id")
    @NotNull(message = "Degree id cannot be null")
    private Long degreeId;

    public Student() {
    }

    public Student(String name, String lastname, String email, String phone_number, Long degreeId) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.degreeId = degreeId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", degreeId=" + degreeId +
                '}';
    }
}
