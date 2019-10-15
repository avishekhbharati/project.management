package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private ProjectManagementService projectManagementService;

	public UserDTO login(String userName) {
		UserDTO user = null;
		List<UserDTO> users = projectManagementService.getProjectMangement().getUsers();
		for (UserDTO userDTO : users) {
			if (userDTO.getUserName().equalsIgnoreCase(userName))
				user = userDTO;
		}
		return user;
	}

	public List<UserDTO> getAllUsers() {
		return projectManagementService.getProjectMangement().getUsers();
	}

	public boolean validateUser(String name, String email, String role) {
		List<UserDTO> users = projectManagementService.getProjectMangement().getUsers();
		
		if(users.isEmpty())
			return true;
		
		for (UserDTO user : users) {
			if (user.getEmail().equals(email))
				return false;
		}
		return true;
	}

	public String addNewUser(UserDTO u)  {		
		if (!validateUser(u.getUserName(), u.getEmail(), u.getRole()))
			return  "User is invalid.";
		try {
			projectManagementService.getProjectMangement().getUsers().add(u);
			return  "User added.";
		}catch(Exception ex) {
			return  "Failed to add new user. Exception: "+ex.getMessage();
		}	
	}
	
	public String deleteUser(int userid) {
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();
				
		UserDTO userTodel = null;
		for (UserDTO userDto : userList) {
			if (userDto.getId().equals(userid)) {
				userTodel = userDto;
				break;
			}			
		}		

		if (userTodel == null)
			return "User with id: "+ userid +" is not in db.";
		
		int userToDelIndex = userList.indexOf(userTodel);

		projectManagementService.getProjectMangement().getUsers().remove(userToDelIndex);
		return "User deleted.";
	}

	public String editUser(UserDTO user) {
		//get all users;
		List<UserDTO> userList =  projectManagementService.getProjectMangement().getUsers();
		
		UserDTO userToEdit = null;
		for (UserDTO userDto : userList) {
			if (userDto.getId().equals(user.getId())) {
				userToEdit = userDto;
				break;
			}			
		}
		
		if (userToEdit == null) {
			return "User with id: " + user.getId() + " is not in db.";
		}

		userToEdit.setEmail(user.getEmail());
		userToEdit.setUserName(user.getUserName());
		userToEdit.setRole(user.getRole());
		return "User Edited.";
	}	
}
