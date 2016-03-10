package net.gluck.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
 * @author John Gluck
 * @date 03/08/2016
 * 
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@CrossOrigin 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
