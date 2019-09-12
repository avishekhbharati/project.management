package sef.project.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javassist.NotFoundException;
import sef.project.management.entity.User;
import sef.project.management.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@CrossOrigin(origins = "http://localhost:9080")
	@GetMapping(path = "/list")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	
	@PostMapping(path = "/save")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String role) {
		String response ="";
		try {
			if (userService.addNewUser(name, email, role) != null) {
				response =  "New user added";				
			}				
		} catch (NotFoundException e) {
			e.printStackTrace();
			response = "Failed to add new user";
		}
		return response;
	}
	
	
	@DeleteMapping(path = "/delete")
	public  @ResponseBody String deleteUser(@RequestParam Integer id) {
		try {
			userService.deleteUser(id);
			return "User deleted";
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 return e.getMessage();
		}
	}
	
	
	@PutMapping(path = "/edit")
	public @ResponseBody String editUser(@RequestParam Integer id, @RequestParam Optional<String> name, @RequestParam Optional<String> email, @RequestParam Optional<String> role ) {
		try {
			userService.editUser(id, name.get(), email.get(), role.get());
			return "User edited.";
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to edit user. Message: "+ e.getMessage();
		}
	}
}