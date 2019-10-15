package sef.project.management.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import sef.project.management.configuration.ProjectManagement;
import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.Skill;
import sef.project.management.entity.User;
import sef.project.management.repository.SkillRepository;
import sef.project.management.repository.UserRepository;

@Service
public class ProjectManagementService {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SkillRepository skillRepository;

	public ProjectManagement getProjectMangement() {
		ProjectManagement pm = context.getBean(ProjectManagement.class);
		return pm;
	}

	public ProjectManagement saveProjectManagement() {

		ProjectManagement pm = getProjectMangement();
		ModelMapper modelMapper = new ModelMapper();

		// Save all users
		List<User> users = new ArrayList<User>();
		for (UserDTO userDto : pm.getUsers()) {
			User user = modelMapper.map(userDto, User.class);
			users.add(user);
		}
		userRepository.deleteAll();
		userRepository.saveAll(users);

		// Save all skills
		List<Skill> skills = new ArrayList<Skill>();
		for (SkillDTO skillDto : pm.getSkills()) {
			Skill skill = modelMapper.map(skillDto, Skill.class);
			skills.add(skill);
		}
		skillRepository.deleteAll();
		skillRepository.saveAll(skills);
		return pm;
	}
}
