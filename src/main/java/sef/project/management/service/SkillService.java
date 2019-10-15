package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.dto.UserSkillDTO;
import sef.project.management.exception.NotFoundException;

@Service
public class SkillService {

	@Autowired
	private ProjectManagementService projectManagementService;

	public List<SkillDTO> getAllSkills() {
		return projectManagementService.getProjectMangement().getSkills();
	}

	public UserDTO addSkill(Integer userId, UserSkillDTO userSkill) throws NotFoundException {
		UserDTO userDTO = null;
		List<UserDTO> users = projectManagementService.getProjectMangement().getUsers();
		for (UserDTO user : users) {
			if (user.getId() == userId.intValue()) {
				user.getUserSkills().add(userSkill);
				userDTO = user;
			}
		}
		if (userDTO == null || userSkill == null)
			throw new NotFoundException("User Not Found");
		return userDTO;
	}

	public UserDTO updateSkillLevel(Integer userId, Integer newSkillLevel, UserSkillDTO userSkill)
			throws NotFoundException {
		UserDTO userDTO = null;
		List<UserDTO> users = projectManagementService.getProjectMangement().getUsers();
		for (UserDTO user : users) {
			if (user.getId() == userId.intValue()) {
				for (UserSkillDTO us : user.getUserSkills()) {
					if (us.getSkill().getSkillId().intValue() == userSkill.getSkill().getSkillId().intValue()) {
						us.setSkillLevel(newSkillLevel);
						userDTO = user;
					}
				}
			}
		}
		if (userDTO == null)
			throw new NotFoundException("Skill for the User Not Found");
		return userDTO;
	}

	public List<SkillDTO> createSkill(SkillDTO skill) {
		List<SkillDTO> skills = getAllSkills();
		skills.add(skill);
		return skills;
	}
}
