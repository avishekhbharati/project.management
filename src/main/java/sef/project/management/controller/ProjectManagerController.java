package sef.project.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.dto.ActivityDTO;
import sef.project.management.dto.FullTimeDeveloperDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.entity.Activity;
import sef.project.management.service.FullTimeDeveloperService;
import sef.project.management.service.ProjectManagerService;

@Controller
@RequestMapping(path = "/projectmanager")
public class ProjectManagerController {

	@Autowired
	private ProjectManagerService projectmanagerservice;

	@PostMapping(path = "/addactivity")
	public @ResponseBody ProjectManagerDTO AddActivityToProject(@RequestParam Integer userId,
			@RequestParam Integer projectId, @RequestBody ActivityDTO activity) {
		return projectmanagerservice.addActivityToProject(userId, projectId, activity);
	}

}