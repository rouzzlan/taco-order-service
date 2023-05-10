package com.falcontech.tacoorderservice.repo;


import com.falcontech.tacoorderservice.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {}
