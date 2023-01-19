package com.order;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;
    private DiscountHandler discountHandler;

    public OrderController(OrderRepository orderRepository, DiscountHandler discountHandler) {
        this.orderRepository = orderRepository;
        this.discountHandler = discountHandler;
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

//    @PostMapping
//    public Order placeOrder(@RequestBody PlaceOrderRequest request) {
//        return discountHandler.placeOrder(request.getCustomerId(), request.getItems());
//    }
}
