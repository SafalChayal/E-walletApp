package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class GateWayConfiguration {
 
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return
		builder.routes().
		route(p->p.path("/orderwithFeign/**").uri("lb://order-service")).
		route(p->p.path("/orderwithloadbalancer/**").uri("lb://order-service")).
		build();
	}
}
