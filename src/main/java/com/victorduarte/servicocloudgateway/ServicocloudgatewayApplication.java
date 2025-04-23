package com.victorduarte.servicocloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicocloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicocloudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
				.route(route -> route.path("/api/client/**").uri("lb://servicoclientes"))
				.route(route -> route.path("/api/credit_card/**").uri("lb://servicocartoes"))
				.build();
	}
}
