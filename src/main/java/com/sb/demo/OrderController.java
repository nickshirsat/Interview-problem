package com.sb.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepo repo;
	
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute(name = "Order") Order order) {
		repo.save(order);
		System.out.println("Data saved!");
		return order.toString();
	}
	
	@GetMapping("get-order/{id}")
	public String getOrder(@PathVariable Integer id) {
		Optional<Order> order = repo.findById(id);
		System.out.println(id);
		return order.toString();
	}
}
