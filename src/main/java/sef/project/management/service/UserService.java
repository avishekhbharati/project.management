package sef.project.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.constants.Constants;
import sef.project.management.dto.ActivityAllocationDTO;
import sef.project.management.dto.ContractorDTO;
import sef.project.management.dto.ContractorDetailsDTO;
import sef.project.management.dto.FullTimeDeveloperDTO;
import sef.project.management.dto.FullTimeDeveloperDetailsDTO;
import sef.project.management.dto.ProjectDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.dto.UserSkillDTO;

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

		if (users.isEmpty())
			return true;

		for (UserDTO user : users) {
			if (email.equals(user.getEmail()))
				return false;
		}
		return true;
	}

	public UserDTO addNewUser(UserDTO u) {
		if (!validateUser(u.getUserName(), u.getEmail(), u.getRole()))
			return null;
		if (Constants.ROLE_CONTRACTOR.equals(u.getRole())) {
			ContractorDTO contractorDto = new ContractorDTO();
			contractorDto.setId(u.getId());
			contractorDto.setEmail(u.getEmail());
			contractorDto.setRole(u.getRole());
			contractorDto.setActivityAllocations(new ArrayList<ActivityAllocationDTO>());
			contractorDto.setContractorDetails(new ArrayList<ContractorDetailsDTO>());
			contractorDto.setUserName(u.getUserName());
			contractorDto.setUserSkills(new ArrayList<UserSkillDTO>());
		} else if (Constants.ROLE_FULL_TIME_DEVELOPER.equals(u.getRole())) {
			FullTimeDeveloperDTO fullTimeDeveloperDTO = new FullTimeDeveloperDTO();
			fullTimeDeveloperDTO.setId(u.getId());
			fullTimeDeveloperDTO.setEmail(u.getEmail());
			fullTimeDeveloperDTO.setRole(u.getRole());
			fullTimeDeveloperDTO.setActivityAllocations(new ArrayList<ActivityAllocationDTO>());
			fullTimeDeveloperDTO.setFullTimeDeveloperDetails(new ArrayList<FullTimeDeveloperDetailsDTO>());
			fullTimeDeveloperDTO.setUserName(u.getUserName());
			fullTimeDeveloperDTO.setUserSkills(new ArrayList<UserSkillDTO>());
		}  else if (Constants.ROLE_PROJECT_MANAGER.equals(u.getRole())) {
			ProjectManagerDTO fullTimeDeveloperrDTO = new ProjectManagerDTO();
			fullTimeDeveloperrDTO.setId(u.getId());
			fullTimeDeveloperrDTO.setEmail(u.getEmail());
			fullTimeDeveloperrDTO.setRole(u.getRole());
			fullTimeDeveloperrDTO.setActivityAllocations(new ArrayList<ActivityAllocationDTO>());
			fullTimeDeveloperrDTO.setProjectsManaged(new ArrayList<ProjectDTO>());
			fullTimeDeveloperrDTO.setUserName(u.getUserName());
			fullTimeDeveloperrDTO.setUserSkills(new ArrayList<UserSkillDTO>());
		}
		projectManagementService.getProjectMangement().getUsers().add(u);
		return u;
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
			return "User with id: " + userid + " is not in db.";

		int userToDelIndex = userList.indexOf(userTodel);

		projectManagementService.getProjectMangement().getUsers().remove(userToDelIndex);
		return "User deleted.";
	}

	public String editUser(UserDTO user) {
		// get all users;
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();

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
