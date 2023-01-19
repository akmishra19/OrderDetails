package com.order;

import org.springframework.data.annotation.Id;

public class Customer {
	
//	@Id
	 private Integer id;
	    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		private String name;
	    
	    
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
}
