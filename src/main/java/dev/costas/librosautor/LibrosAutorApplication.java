package dev.costas.librosautor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.StartupStep;

@SpringBootApplication
public class LibrosAutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrosAutorApplication.class, args);
	}

}
