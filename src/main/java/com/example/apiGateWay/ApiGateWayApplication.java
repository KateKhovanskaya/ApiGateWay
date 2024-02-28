package com.example.apiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}

	@Bean
	public RouteLocator notesRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("noteService", r->r.path("/notes/**")
						.uri("http://localhost:8080/"))
				.route("taskService", r->r.path("/tasks/**")
						.uri("http://localhost:8081/"))
				.build();
	}
}
