package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sef.project.management.entity.User;
import sef.project.management.repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/")
	public @ResponseBody String test () {
		return "Hello World!";
	}
	
	@GetMapping(path="/save")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/list")
	public @ResponseBody List<User> getAllUsers() {
		return userRepository.getUsers();
	}
}