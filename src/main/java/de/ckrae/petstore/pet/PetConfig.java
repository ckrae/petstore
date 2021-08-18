package de.ckrae.petstore.pet;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConfig {

	@Bean
	CommandLineRunner commandLineRunner(PetRepository repository) {
		return args -> {
			Pet wauwau = new Pet(null, "Wauwau", null, null, Status.PENDING);
			Pet igly = new Pet(null, "Igly", null, null, Status.AVAILABLE);
			Pet cat = new Pet(null, "Miau", null, null, Status.AVAILABLE);
			repository.saveAll(List.of(wauwau, igly, cat));
		};
	}

}
