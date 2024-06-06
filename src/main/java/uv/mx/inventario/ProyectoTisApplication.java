package uv.mx.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "uv.mx.inventario") 
public class ProyectoTisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTisApplication.class, args);
	}

}
