package sef.project.management.configuration;

import java.util.ArrayList;
import java.util.List;

import sef.project.management.dto.ProjectDTO;
import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;

public class ProjectManagement {

	private List<UserDTO> users = new ArrayList<UserDTO>();
	private List<SkillDTO> skills = new ArrayList<SkillDTO>();
	
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	public List<SkillDTO> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}
}
