package sef.project.management.dto;

import java.util.List;

public class ProjectDTO {

	private Integer projectId;
	private String projectName;
	private List<ActivityDTO> projectActivities;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<ActivityDTO> getProjectActivities() {
		return projectActivities;
	}

	public void setProjectActivities(List<ActivityDTO> projectActivities) {
		this.projectActivities = projectActivities;
	}
}