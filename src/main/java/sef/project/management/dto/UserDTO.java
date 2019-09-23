package sef.project.management.dto;

import java.util.List;

public class UserDTO {
	
	private Integer id;
	private String userName;
	private String email;
	private String role;
	private List<UserSkillDTO> userSkills;
	private List<ActivityAllocationDTO> activityAllocations;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<UserSkillDTO> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkillDTO> userSkills) {
		this.userSkills = userSkills;
	}
	public List<ActivityAllocationDTO> getActivityAllocations() {
		return activityAllocations;
	}
	public void setActivityAllocations(List<ActivityAllocationDTO> activityAllocations) {
		this.activityAllocations = activityAllocations;
	}
	
}