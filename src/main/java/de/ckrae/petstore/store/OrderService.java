package de.ckrae.petstore.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final OrderRepository repository;

	@Autowired
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public void addOrder(Order order) {
		this.repository.save(order);
	}

	public void deleteOrder(Long orderId) {
		this.repository.deleteById(orderId);
	}

	public Order getOrder(Long orderId) {
		Order order = this.repository.getById(orderId);
		return order;
	}

}
