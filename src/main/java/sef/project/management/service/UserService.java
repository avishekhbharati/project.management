package sef.project.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.User;
import sef.project.management.repository.UserRepository;

@Service
public class UserService {

	// TODO Remove this autowiring and get the data from the model
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectManagementService projectManagementService;

	private ArrayList<User> userList = new ArrayList<User>(); // FOR TESTING.

	public List<UserDTO> getAllUsers() {
		return projectManagementService.getProjectMangement().getUsers();
	}

	public boolean validateUser(String name, String email, String role) {
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getEmail().equals(email))
				return false;
		}
		return true;
	}

	public User addNewUser(String name, String email, String role) throws NotFoundException {
		if (!validateUser(name, email, role))
			throw new NotFoundException("User is invalid.");

		User user = createUser(name, email, role);
		return userRepository.save(user);
	}

	public User addNewUser(User u) throws NotFoundException {
		if (!validateUser(u.getUserName(), u.getEmail(), u.getRole()))
			throw new NotFoundException("User is invalid.");
		return userRepository.save(u);
	}

	public void deleteUser(User user) throws NotFoundException {
		Optional<User> userOpt = userRepository.findById(user.getId());

		if (!userOpt.isPresent()) {
			throw new NotFoundException("User with id: " + user.getId() + " is not in db.");
		}

		userRepository.delete(user);
	}

	public void deleteUser(Integer id) throws NotFoundException {
		Optional<User> userOpt = userRepository.findById(id);

		if (!userOpt.isPresent()) {
			throw new NotFoundException("User with id: " + id + " is not in db.");
		}
		userRepository.deleteById(id);
	}

	public User editUser(Integer id, String userName, String email, String role) throws NotFoundException {
		Optional<User> userOpt = userRepository.findById(id);
		if (!userOpt.isPresent()) {
			throw new NotFoundException("User with id: " + id + " is not in db.");
		}

		User user = userOpt.get();
		user.setEmail(email);
		user.setUserName(userName);
		user.setRole(role);
		return userRepository.save(user);
	}

	public User createUser(String name, String email, String role) {
		User user = new User();
		user.setUserName(name);
		user.setEmail(email);
		user.setRole(role);
		return user;
	}

	// For Test
	public void addUser(String name, String email, String role) {
		User user = createUser(name, email, role);
		userList.add(user);
	}

	public void addUser(User u) {
		userList.add(u);
	}

	public void removeUser(User user) {
		userList.remove(user);
	}

	public int getUsersCount() {
		return userList.size();
	}
}
