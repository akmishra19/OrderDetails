package com.order;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private CustomerEntity customer;
	    
//	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "order_id")
	    private List<Item> items;
	    
	    @Column(name = "discount")
	    private double discount;
	    
	    // Getters and setters
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public CustomerEntity getCustomer() {
	        return customer;
	    }
	    public void setCustomer(CustomerEntity customer) {
	        this.customer = customer;
	    }
	    public List<Item> getItems() {
	        return items;
	    }
	    public void setItems(List<Item> items) {
	        this.items = items;
	    }
	    public double getDiscount() {
	        return discount;
	    }
	    public void setDiscount(double discount) {
	        this.discount = discount;
	    }
	}



