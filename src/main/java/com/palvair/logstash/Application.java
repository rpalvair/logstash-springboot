package com.palvair.logstash;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.log4j.Log4j;

@SpringBootApplication
@Log4j
public class Application {
	
	public static void main(String[] args) {
		final SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.run(args);
		log.debug("app is running");
	}
	
	@Bean
	public PropertySource<?> yamlPropertySourceLoader() throws IOException {
		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
		PropertySource<?> applicationYamlPropertySource = loader.load("application.yml",
				new ClassPathResource("application.yml"), "default");
		return applicationYamlPropertySource;
	}
}
