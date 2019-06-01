package com.eduardadebrum.srmBackend;

import com.eduardadebrum.srmBackend.repository.RepositoryScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {RepositoryScan.class})
@SpringBootApplication
public class SrmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmBackendApplication.class, args);
	}

}
