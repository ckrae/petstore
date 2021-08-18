package de.ckrae.petstore.store;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "store")
public class OrderController {

	private final OrderService service;

	@Autowired
	public OrderController(OrderService service) {
		this.service = service;
	}

	@GetMapping(path = "/inventory")
	public Map<String, String> getInventory() {
		return null;
	}

	@PostMapping(path = "/order")
	public void placeOrder(@RequestBody Order order) {
		this.service.addOrder(order);
	}

	@GetMapping(path = "/order/{orderId}")
	public Order getOrderById(@PathParam("orderId") Long orderId) {
		return this.service.getOrder(orderId);
	}

	@DeleteMapping(path = "/order/{orderId}")
	public void deleteOrder(@PathParam("orderId") Long orderId) {
		this.service.deleteOrder(orderId);
	}

}
