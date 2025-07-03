package com.example.faol.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenApiConfig {

    @Value("${server.port:8081}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server()
                                .url("http://localhost:" + serverPort)
                                .description("Servidor Local")
                ))
                .info(new Info()
                        .title("API de Gestión de Cursos")
                        .version("1.0")
                        .description("API REST para la gestión de cursos con operaciones CRUD")
                                        .contact(new Contact()
                                                .name("Equipo de Desarrollo")
                                                .email("desarrollo@empresa.com")
                                                .url("https://www.empresa.com"))
                                        .license(new License()
                                                .name("Apache 2.0")
                                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
