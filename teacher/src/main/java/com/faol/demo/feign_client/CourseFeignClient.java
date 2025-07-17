package com.faol.demo.feign_client;

import com.faol.demo.models.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "course", url = "${client.course.url}")
public interface CourseFeignClient {

    //este endpoint debe coincidir exacto con el del metodo CourseTeacherController del microservicio course
    //@RequestMapping("/course/teacher") + @GetMapping("/allCoursesByTeacherId/{teacherId}")
    @GetMapping("/course/teacher/allCoursesByTeacherId/{teacherId}")
    public List<CourseDTO> getAllCoursesByTeacherId(@PathVariable Long teacherId);

    //la url completa sería: http://localhost:8081/course/teacher/allCoursesByTeacherId/2 o el numero del id deseado

}
