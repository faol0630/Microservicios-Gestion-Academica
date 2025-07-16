package com.faol.demo.service;

import com.faol.demo.dto.TeacherDTO;
import com.faol.demo.entity.Teacher;
import com.faol.demo.exception.ResourceNotFoundException;
import com.faol.demo.mapper.TeacherMapper;
import com.faol.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherServiceInt{

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Teacher not found for this id: " + id) );
        return TeacherMapper.toDTO(teacher);
    }

    @Override
    public TeacherDTO saveTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.toDTO(savedTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(Teacher teacher, Long id) {
        Teacher teacher1 = teacherRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Teacher not found for this id: " + id) );

        teacher1.setName(teacher.getName());
        teacher1.setLastname(teacher.getLastname());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setPhoneNumber(teacher.getPhoneNumber());

        Teacher updatedTeacher = teacherRepository.save(teacher1);
        return TeacherMapper.toDTO(updatedTeacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);

    }

    @Override
    public void deleteAllTeachers() {
        teacherRepository.deleteAll();

    }

    @Override
    public Long getTeacherCount() {
        return teacherRepository.count();
    }
}
