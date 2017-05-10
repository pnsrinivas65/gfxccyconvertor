package com.anz.gfx.ccycon;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.anz.gfx.ccycon.filter.ApiOriginFilter;

/**
 * The accounts web-application. This class has two uses:
 * <ol>
 * <li>Provide configuration and setup for micosrvice ... or</li>
 * <li>Run as a stand-alone Spring Boot web-application for testing (in which
 * case there is <i>no</i> microservice registration</li>
 * </ol>
 * <p>
 * To execute as a microservice, run Microserver class instead.
 * 
 */
@SpringBootApplication
@EntityScan("com.anz.gfx.ccycon.model")
@EnableJpaRepositories("com.anz.gfx.ccycon.model.repository")
@PropertySource("classpath:db-config.properties")
public class WebApplication {

	protected Logger logger = Logger.getLogger(WebApplication.class
			.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
	public javax.servlet.Filter apiOriginFilter() {
		return new ApiOriginFilter();
	}

}
