package net.gluck;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.gluck.domain.Account;
import net.gluck.domain.persistence.AccountRepository;

/*
 * @author John Gluck
 * @date 03/08/2016
 * 
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(final AccountRepository accountRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				// TODO: This is not all that secure. Bad user name and password
				// checked into the
				// repository.
				accountRepository.save(new Account("username", "password"));
			}
		};
	}
}
