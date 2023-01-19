package com.order;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	
	    private DiscountService discountService;
	    private List<OrderEntity> orders;

	    public OrderService(DiscountService discountService, List<OrderEntity> orders) {
	        this.discountService = discountService;
	        this.orders = orders;
	    }

	    public OrderEntity placeOrder(int customerId, List<Item> items) {
	    	OrderEntity order = new OrderEntity();
	    	CustomerEntity customer = new CustomerEntity();
	    	customer.setId(customerId);
	        order.setItems(items);
	        
	        // Calculate discount for the order
	        double discount = discountService.calculateDiscount(customerId, orders);
	        order.setDiscount(discount);
	        
	        // Add the order to the list of orders
	        orders.add(order);
	        
	        return order;
	    }
	}



