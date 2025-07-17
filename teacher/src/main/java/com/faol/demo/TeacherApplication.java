package com.faol.demo;

import com.faol.demo.entity.Teacher;
import com.faol.demo.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TeacherApplication implements CommandLineRunner {

	TeacherRepository teacherRepository;

	public TeacherApplication(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long size = teacherRepository.count();

		if (size == 0) {
			Teacher teacher1 = new Teacher(
					"Juan Carlos",
					"Perez V",
					"juanca2@mail.net",
					"993774881"
			);
			teacherRepository.save(teacher1);

			Teacher teacher2 = new Teacher(
					"Luisa Maria",
					"Torres Gomez",
					"luisam332@net.com",
					"993774882"
			);
			teacherRepository.save(teacher2);

			Teacher teacher3 = new Teacher(
					"Marcos Alfonso",
					"Suarez Diez",
					"marcoss1243@mail.com",
					"746583921"
			);
			teacherRepository.save(teacher3);
		}

		System.out.println("\n========================================================");
		System.out.println("    🚀 Sistema de Gestión de Profesores Iniciado");
		System.out.println("    ✅ Servidor Tomcat iniciado correctamente");
		System.out.println("    📚 Swagger UI: http://localhost:8083/swagger-ui.html");
		System.out.println("    ✅ DB Url: http://localhost/phpmyadmin");
		System.out.println("========================================================\n");
	}
}
