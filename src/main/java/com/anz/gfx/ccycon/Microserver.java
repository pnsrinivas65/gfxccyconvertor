package com.anz.gfx.ccycon;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link WebApplication}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link WebApplication#main(String[])}</li>
 * <li>As a microservice - by executing {@link MicroServer#main(String[])}</li>
 * </ul>
 * 
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(WebApplication.class)
public class Microserver {

	protected Logger logger = Logger.getLogger(Microserver.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {

		switch (args.length) {
			case 2:
				// Optionally set the HTTP port to listen on, overrides
				// value in the <server-name>-server.yml file
				System.setProperty("server.port", args[1]);
				break;
	
			default:
				usage();
				return;
		}

		// Tell server to look for application.properties or application.yml
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(Microserver.class, args);
	}
	
	protected static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println("     where server-name is 'registration', "
				+ "'accounts' or 'web' and server-port > 1024");
	}
}
