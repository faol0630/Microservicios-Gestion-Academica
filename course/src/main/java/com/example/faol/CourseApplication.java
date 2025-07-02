package com.example.faol;

import com.example.faol.entity.Course;
import com.example.faol.repository.CourseRepository;
import com.example.faol.service.CourseServiceImpl;
import com.example.faol.service.CourseServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		long size = courseRepository.count();
		if (size == 0){
			Course course1 = new Course("Java", "12 months", 1000.0, 1L);
			courseRepository.save(course1);

			Course course2 = new Course("Python", "10 months", 500.0, 2L);
			courseRepository.save(course2);

			Course course3 = new Course("C++", "15 months" , 1500.0, 2L);
			courseRepository.save(course3);

			Course course4 = new Course("C#", "18 months", 2000.0, 1L);
			courseRepository.save(course4);

			Course course5 = new Course("JavaScript", "15 months", 1000.0, 3L);
			courseRepository.save(course5);

			Course course6 = new Course("SQL", "12 months", 1500.0, 3L);
			courseRepository.save(course6);

			Course course7 = new Course("HTML", "10 months" , 1000.0, 2L);
			courseRepository.save(course7);

			Course course8 = new Course("CSS", "12 months", 1500.0, 1L);
			courseRepository.save(course8);
		}

		System.out.println("\n========================================================");
		System.out.println("\n========================================================");
		System.out.println("    🚀 Microservicio de Cursos Iniciado");
		System.out.println("    ✅ Servidor Tomcat iniciado correctamente");
		System.out.println("    ✅ Url: http://localhost:8081/course");
		System.out.println("========================================================\n");
		System.out.println("========================================================\n");
	}
}
