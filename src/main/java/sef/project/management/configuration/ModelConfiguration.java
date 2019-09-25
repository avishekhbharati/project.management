package sef.project.management.configuration;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sef.project.management.constants.Constants;
import sef.project.management.dto.ContractorDTO;
import sef.project.management.dto.FullTimeDeveloperDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.Skill;
import sef.project.management.entity.User;
import sef.project.management.repository.SkillRepository;
import sef.project.management.repository.UserRepository;

@Component
public class ModelConfiguration {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SkillRepository skillRepository;

	// Create a singleton project management bean for all API calls
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ProjectManagement getProjectManagement() {

		// Model for the entire application
		ProjectManagement projectManagement = new ProjectManagement();

		// Create model mapper to convert entity to DTO
		ModelMapper modelMapper = new ModelMapper();

		// Get all users and add them to the model
		List<User> users = userRepository.getUsers();
		for (User u : users) {
			UserDTO user = null;
			// Map user entity to user DTO based on role
			if (u.getRole().equals(Constants.ROLE_CONTRACTOR)) {
				user = modelMapper.map(u, ContractorDTO.class);
			} else if (u.getRole().equals(Constants.ROLE_FULL_TIME_DEVELOPER)) {
				user = modelMapper.map(u, FullTimeDeveloperDTO.class);
			} else if (u.getRole().equals(Constants.ROLE_PROJECT_MANAGER)) {
				user = modelMapper.map(u, ProjectManagerDTO.class);
			}
			projectManagement.getUsers().add(user);
		}

		// Get all skills and add them to the model
		List<Skill> skills = skillRepository.getSkills();
		for (Skill s : skills) {
			// Map skill entity to skill DTO
			SkillDTO user = modelMapper.map(s, SkillDTO.class);
			projectManagement.getSkills().add(user);
		}

		return projectManagement;
	}

}
