package com.ExamenParcialSanchez.ExamenParcial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamenParcialApplication {

    // Crear un Logger para la clase ExamenParcialApplication
    private static final Logger logger = LoggerFactory.getLogger(ExamenParcialApplication.class);

    public static void main(String[] args) {
        try {
            // Log para indicar que la aplicación está iniciando
            logger.info("Iniciando la aplicación...");

            // Ejecutar la aplicación Spring Boot
            SpringApplication.run(ExamenParcialApplication.class, args);
        } catch (Exception e) {
            // Log de error si ocurre una excepción
            logger.error("Error al iniciar la aplicación", e);
        }
    }
}