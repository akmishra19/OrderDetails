package com.order;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

@Service
public class DiscountHandler {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private DiscountService discountService;

    public DiscountHandler(CustomerRepository customerRepository, OrderRepository orderRepository, DiscountService discountService) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.discountService = discountService;
    }

    public OrderEntity placeOrder(int customerId, List<Item> items) {
    	OrderEntity order = new OrderEntity();
//        order.setCustomerId(customerRepository.findById(customerId).get());
    	CustomerEntity customer = new CustomerEntity();
    	customer.setId(customerId);
 
    	order.setCustomer(customer);
//        order.setCustomerId(customerId);
        order.setItems(items);
        
        // Calculate discount for the order
        double discount = discountService.calculateDiscount(customerId, orderRepository.findAll());
        order.setDiscount(discount);
        
        // Add the order to the list of orders
        order = orderRepository.save(order);
        
        return order;
    }

    public void applyBfcmDiscount() {
        List<CustomerEntity> customers = customerRepository.findAll();
        for (CustomerEntity customer : customers) {
            List<OrderEntity> orders = orderRepository.findByCustomer(customer);
            for (OrderEntity order : orders) {
                double discount = order.getDiscount();
                discount += 0.15;
                order.setDiscount(discount);
                orderRepository.save(order);
            }
        }
    }
}

