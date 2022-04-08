package com.rakuten;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	List<Order> orders = new ArrayList<>();
	
	void save(Order order) {
		if(order.getPrice()<0) {
			throw new IllegalArgumentException("Price can't be negative " + order.getPrice());
		}
		System.out.println(String.format("Order Item = %s\n Order Price = %d", order.getItem(), order.getPrice()));
		orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}
}
