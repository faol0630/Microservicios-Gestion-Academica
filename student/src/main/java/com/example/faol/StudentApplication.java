package com.example.faol;

import com.example.faol.entity.Student;
import com.example.faol.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	StudentRepository studentRepository;

	public StudentApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long size = studentRepository.count();
		if (size == 0){
			Student student = new Student(
					"Jorge",
					"Garcia",
					"jorgeg12@mail.net",
					"172382181",
					1L
			);
			studentRepository.save(student);

			Student student2 = new Student(
					"Juan",
					"Lopez",
					"juanlo21@net.com",
					"867120342",
					2L
			);
			studentRepository.save(student2);

			Student student3 = new Student(
					"Maria",
					"Gomez",
					"mariag44@mail.com",
					"948728166",
					1L
			);
			studentRepository.save(student3);
		}

		System.out.println("\n========================================================");
		System.out.println("\n========================================================");
		System.out.println("    🚀 Microservicio de Estudiantes Iniciado");
		System.out.println("    ✅ Servidor Tomcat iniciado correctamente");
		System.out.println("    📚 Swagger UI: http://localhost:8080/swagger-ui.html");
		System.out.println("    ✅ Url: http://localhost:8080/student");
		System.out.println("    ✅ DB Url: http://localhost/phpmyadmin");
		System.out.println("========================================================\n");
		System.out.println("========================================================\n");
	}
}
