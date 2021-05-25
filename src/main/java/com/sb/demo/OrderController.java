package com.sb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepo repo;
	
	@PostMapping("/save-order")
	public void saveOrder(@ModelAttribute(name = "Order") Order order) {
		repo.save(order);
		System.out.println("Data saved!");
		System.out.println(order);
	}
}
