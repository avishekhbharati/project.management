package sef.project.management.dto;

import java.util.List;

public class ProjectDTO {

	private Integer projecctId;
	private String projectName;
	private ProjectManagerDTO allocatedBy;
	private List<ActivityDTO> projectActivities;
	
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
	public ProjectManagerDTO getAllocatedBy() {
		return allocatedBy;
	}
	public void setAllocatedBy(ProjectManagerDTO allocatedBy) {
		this.allocatedBy = allocatedBy;
	}
	public List<ActivityDTO> getProjectActivities() {
		return projectActivities;
	}
	public void setProjectActivities(List<ActivityDTO> projectActivities) {
		this.projectActivities = projectActivities;
	}
}