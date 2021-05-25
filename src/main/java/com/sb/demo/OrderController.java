package com.sb.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepo oRepo;
	
	@PostMapping("/saveorders")
	@ResponseBody
	public String SaveOrders(@ModelAttribute("order") Order o) {
		oRepo.save(o);
		return o.toString();
	}
	
	@GetMapping("/getorder/{order_id}")
	@ResponseBody
	public Optional<Order> getOrder(@PathVariable Integer order_id) {
		return oRepo.findById(order_id);
	}
	

}
