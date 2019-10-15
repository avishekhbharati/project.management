package sef.project.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javassist.NotFoundException;
import sef.project.management.dto.UserDTO;
import sef.project.management.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/login")
	public @ResponseBody UserDTO getAllUsers(@RequestParam String userName) {
		return userService.login(userName);
	}
	
	@GetMapping(path = "/list")
	public @ResponseBody List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping(path = "/save")
	public @ResponseBody String addNewUser(@RequestBody UserDTO user) {		
		return userService.addNewUser(user);
	}
		
	@DeleteMapping(path = "/delete")
	public  @ResponseBody String deleteUser(@RequestBody Integer id) {
		return userService.deleteUser(id);
	}
	
	@PutMapping(path = "/edit")
	public @ResponseBody String editUser(@RequestBody UserDTO user) {
		return userService.editUser(user);
	}
}