package envios.transporte;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"envios.transporte"})
@EnableJpaRepositories(basePackages = {"envios.transporte.Repositorio"})
@EntityScan(basePackages = {"envios.transporte.Modelo"}) // Agrega esta línea
public class TransporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransporteApplication.class, args);
	}

}
