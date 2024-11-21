package br.edu.atitus.paradigma.api_gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cambio_service", r -> r.path("/cambio-service/**")
                        .filters(f -> f.addRequestHeader("Usuario", "Emily Biecoski"))
                        .uri("http://cambio-service:8080")) 
                .route("produto_service", r -> r.path("/produto-service/**")
                        .filters(f -> f.addRequestHeader("Usuario", "Emily Biecoski"))
                        .uri("http://produto-service:8080")) 
                .route("saudacao_service", r -> r.path("/saudacao-service/**")
                        .filters(f -> f.addRequestHeader("Usuario", "Emily Biecoski"))
                        .uri("http://localhost:8081")) 
                .build();
    }
}
