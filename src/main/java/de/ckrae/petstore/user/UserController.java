package de.ckrae.petstore.user;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "user")
public class UserController {

	final public UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping
	@Operation(summary = "Create user")
	public void createUser(@RequestBody User user) {
		this.service.addUser(user);
	}

	@GetMapping(path = "/{username}")
	@Operation(summary = "Get user by user name")
	public User getUser(@PathParam("userName") String userName) {
		return this.service.getUser(userName);
	}

	@PutMapping
	@Operation(summary = "Updated user")
	public void updateUser(@RequestBody User user) {
		this.service.updateUser(user);
	}

	@DeleteMapping
	@Operation(summary = "Delete user")
	public void createUser(@PathParam("userName") String userName) {
		this.service.deleteUser(userName);
	}

}
