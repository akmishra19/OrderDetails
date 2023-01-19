package com.order;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public class Order {

	private int id;
    private int customerId;
    private List<Item> items;
    private double discount;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
