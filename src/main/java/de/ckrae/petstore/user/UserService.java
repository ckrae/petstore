package de.ckrae.petstore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	final public UserRepository repo;

	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public void addUser(User user) {
		this.repo.save(user);

	}

	public User getUser(String userName) {
		return this.repo.getUserByName(userName);

	}

	public void updateUser(User user) {
		this.repo.save(user);

	}

	public void deleteUser(String userName) {

		User user = this.repo.getUserByName(userName);
		this.repo.delete(user);

	}

}
