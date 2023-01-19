package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerRepository.save(customer);
    }
}

