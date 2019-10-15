package sef.project.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.dto.ActivityAllocationDTO;
import sef.project.management.dto.ActivityDTO;
import sef.project.management.dto.ProjectDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.service.ProjectManagerService;

@Controller
@RequestMapping(path = "/projectmanager")
public class ProjectManagerController {

	@Autowired
	private ProjectManagerService projectmanagerservice;

	@PostMapping(path = "/addactivity")
	public @ResponseBody ProjectManagerDTO addActivityToProject(@RequestParam Integer userId,
			@RequestParam Integer projectId, @RequestBody ActivityDTO activity) {
		return projectmanagerservice.addActivityToProject(userId, projectId, activity);
	}

	@PostMapping(path = "/allocateactivity")
	public @ResponseBody UserDTO allocateActivity(@RequestParam Integer userId, @RequestParam Integer projectId,
			@RequestParam Integer activityId, @RequestBody ActivityAllocationDTO activityAllocation) {
		return projectmanagerservice.allocateActivity(userId, projectId, activityId, activityAllocation);
	}

	@PostMapping(path = "/createproject")
	public @ResponseBody ProjectManagerDTO createProject(@RequestParam Integer userId,
			@RequestBody ProjectDTO project) {
		return projectmanagerservice.createProject(userId, project);
	}

}