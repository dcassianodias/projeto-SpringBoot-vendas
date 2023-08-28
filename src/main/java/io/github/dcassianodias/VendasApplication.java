package io.github.dcassianodias;

import io.github.dcassianodias.domain.model.Cliente;
import io.github.dcassianodias.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClienteRepository repository){
		return args -> {
			Cliente c = new Cliente(null, "Danilo");
			repository.save(c);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
