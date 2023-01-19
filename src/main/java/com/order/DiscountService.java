package com.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
	
	
	    public double calculateDiscount(int customerId, List<OrderEntity> orders) {
	        // Find the customer's order history
	        List<OrderEntity> customerOrders = orders.stream()
	                .filter(o -> o.getCustomer().getId() == customerId)
	                .collect(Collectors.toList());
	        int numOrders = customerOrders.size();
	        
	        // Determine the discount based on the number of orders
	        double discount = 0.0;
	        if (numOrders > 20) {
	            discount = 0.2;
	        } else if (numOrders > 10) {
	            discount = 0.1;
	        }
	        
	        return discount;
	    }
	}



