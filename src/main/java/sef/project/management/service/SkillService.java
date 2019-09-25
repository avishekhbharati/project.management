package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.dto.SkillDTO;

@Service
public class SkillService {

	@Autowired
	private ProjectManagementService projectManagementService;

	public List<SkillDTO> getAllSkills() {
		return projectManagementService.getProjectMangement().getSkills();
	}
}
