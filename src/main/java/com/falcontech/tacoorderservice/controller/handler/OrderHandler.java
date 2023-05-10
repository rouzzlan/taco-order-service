package com.falcontech.tacoorderservice.controller.handler;

import com.falcontech.tacoorderservice.model.Order;
import com.falcontech.tacoorderservice.repo.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class OrderHandler {
  private final OrderRepository repository;

  public OrderHandler(OrderRepository repository) {
    this.repository = repository;
  }

  public Mono<ServerResponse> getOrder(ServerRequest request) {
    var id = request.pathVariable("id");
    var order = repository.findById(id);
    return ok().body(order, Order.class);
  }

  public Mono<ServerResponse> getOrders(ServerRequest request) {
    var all = repository.findAll();
    return ok().body(all, Order.class);
  }
}
