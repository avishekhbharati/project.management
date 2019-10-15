package sef.project.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.configuration.ProjectManagement;
import sef.project.management.service.ProjectManagementService;

@Controller
@RequestMapping(path = "/project")
public class ProjectManagementController {

	@Autowired
	private ProjectManagementService projectManagementService;
	
	@GetMapping(path = "/save")
	public @ResponseBody ProjectManagement saveData() {
		return projectManagementService.saveProjectManagement();
	}
}