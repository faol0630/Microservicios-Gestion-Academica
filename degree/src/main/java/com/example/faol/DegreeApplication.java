package com.example.faol;

import com.example.faol.entity.Degree;
import com.example.faol.repository.DegreeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DegreeApplication implements CommandLineRunner {

	DegreeRepository degreeRepository;

	public DegreeApplication(DegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DegreeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long count = degreeRepository.count();
		if (count == 0) {
			Degree degree1 = new Degree("Java backend", "3 years", 10000.00);
			degreeRepository.save(degree1);

			Degree degree2 = new Degree("MERN Stack", "2 years", 8000.00);
			degreeRepository.save(degree2);
		}

		System.out.println("\n========================================================");
		System.out.println("\n========================================================");
		System.out.println("    🚀 Microservicio de Degrees Iniciado");
		System.out.println("    ✅ Servidor Tomcat iniciado correctamente");
		System.out.println("    ✅ Url: http://localhost:8082/degree");
		System.out.println("========================================================\n");
		System.out.println("========================================================\n");
	}
}
