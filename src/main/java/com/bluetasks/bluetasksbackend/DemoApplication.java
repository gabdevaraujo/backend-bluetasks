package com.bluetasks.bluetasksbackend;

import com.bluetasks.bluetasksbackend.domain.task.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class DemoApplication implements RepositoryRestConfigurer{

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Task.class);
		config.getCorsRegistry()
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE");

			logger.info("Repository CORS setup... ok");
	}

	@Bean
	public Validator validator(){
		return new LocalValidatorFactoryBean();
	}

	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener vrel) {
		Validator validator = validator();
		vrel.addValidator("beforeCreate", validator);
		vrel.addValidator("beforeSave", validator);
	}
}
