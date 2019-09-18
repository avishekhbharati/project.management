package sef.project.management.dto;

import java.util.List;

public class User {
	
	private Integer id;
	private String userName;
	private String email;
	private String role;
	private List<UserSkill> userSkills;
	private List<ActivityAllocation> activityAllocations;
	
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
	public List<UserSkill> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}
	public List<ActivityAllocation> getActivityAllocations() {
		return activityAllocations;
	}
	public void setActivityAllocations(List<ActivityAllocation> activityAllocations) {
		this.activityAllocations = activityAllocations;
	}
	
}