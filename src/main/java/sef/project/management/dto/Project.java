package sef.project.management.dto;

import java.util.List;

public class Project {

	private Integer projecctId;
	private String projectName;
	private ProjectManager allocatedBy;
	private List<Activity> projectActivities;
	
	public Integer getProjecctId() {
		return projecctId;
	}
	public void setProjecctId(Integer projecctId) {
		this.projecctId = projecctId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public ProjectManager getAllocatedBy() {
		return allocatedBy;
	}
	public void setAllocatedBy(ProjectManager allocatedBy) {
		this.allocatedBy = allocatedBy;
	}
	public List<Activity> getProjectActivities() {
		return projectActivities;
	}
	public void setProjectActivities(List<Activity> projectActivities) {
		this.projectActivities = projectActivities;
	}
}