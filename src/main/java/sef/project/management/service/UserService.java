package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.entity.User;
import sef.project.management.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.getUsers();
	}

	public User addNewUser(String name, String email) {
		User user = createUser(name, email);
		return userRepository.save(user);
	}

	public User createUser(String name, String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		return user;
	}

}
