package net.gluck.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import net.gluck.api.domain.Account;
import net.gluck.api.domain.persistence.AccountRepository;

@Configuration
public class AppConfiguration {
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
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        };
    }
}
