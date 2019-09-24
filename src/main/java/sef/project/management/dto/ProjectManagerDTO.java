package sef.project.management.dto;

import java.util.List;

public class ProjectManagerDTO extends UserDTO {

	private List<ProjectDTO> projectsManaged;

	public List<ProjectDTO> getProjectsManaged() {
		return projectsManaged;
	}

	public void setProjectsManaged(List<ProjectDTO> projectsManaged) {
		this.projectsManaged = projectsManaged;
	}
}
