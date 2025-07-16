package com.faol.demo.controller;

import com.faol.demo.dto.TeacherDTO;
import com.faol.demo.entity.Teacher;
import com.faol.demo.service.TeacherServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherServiceInt teacherService;

    public TeacherController(TeacherServiceInt teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<TeacherDTO> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/update/{id}")
    public TeacherDTO updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
        return teacherService.updateTeacher(teacher, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacherById(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllTeachers(){
        teacherService.deleteAllTeachers();
    }

    @GetMapping("/count")
    public Long getTeacherCount(){
        return teacherService.getTeacherCount();
    }

}
