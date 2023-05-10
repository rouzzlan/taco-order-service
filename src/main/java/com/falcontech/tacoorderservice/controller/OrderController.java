package com.falcontech.tacoorderservice.controller;

import com.falcontech.tacoorderservice.controller.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderController {
  private static final String ENDPOINT_PATH = "/order";

  @Bean
  RouterFunction<ServerResponse> orderApis(OrderHandler handler) {
    return route()
        .nest(
            path(ENDPOINT_PATH),
            builder -> builder.GET("/{id}", handler::getOrder).GET("", handler::getOrders))
        .build();
  }
}
