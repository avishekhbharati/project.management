package sef.project.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import sef.project.management.configuration.ProjectManagement;

@Service
public class ProjectManagementService {

	@Autowired
	private ApplicationContext context;

	public ProjectManagement getProjectMangement() {
		ProjectManagement pm = context.getBean(ProjectManagement.class);
		return pm;
	}
}
