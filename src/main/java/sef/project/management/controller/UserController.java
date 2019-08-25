package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.entity.User;
import sef.project.management.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/list")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/save")
	public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email) {
		return userService.addNewUser(name, email);
	}

}