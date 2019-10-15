package sef.project.management.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.dto.ActivityDTO;
import sef.project.management.dto.ProjectDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.Activity;
import sef.project.management.entity.User;

@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagementService projectManagementService;

	
	public ActivityDTO scheduleActivity(ActivityDTO activity, Integer startDate, Integer endDate) {
		if (activity != null && startDate != null && endDate != null) {
			if (endDate > startDate) {
				activity.setStartWeek(startDate);
				activity.setEndWeek(endDate);
			}
		}
		return activity;
	}

	public ActivityDTO setActivityDependency(ActivityDTO activity, Integer dependencyActivityId) {
		if (activity != null && activity.getActivityId() != dependencyActivityId) {
			activity.setDependencyActivityId(dependencyActivityId);
		}
		return activity;
	}

	public boolean allocateUserToActivity(ActivityDTO activity, User user, Timestamp startDate, Timestamp endDate) {
		boolean isAllocated = false;
		return true;
	}

	public boolean changeUserInvolvement(User user, ActivityDTO activity, String involvement) {
		return true;
	}

	
	public ProjectManagerDTO addActivityToProject(Integer projectManagerId, Integer projectId, ActivityDTO activity) {
		List<UserDTO> userList =  projectManagementService.getProjectMangement().getUsers();
		ProjectManagerDTO projectManager = null;
		for (UserDTO userDto : userList) {
			if (projectManagerId.equals(userDto.getId())) {
				projectManager = (ProjectManagerDTO) userDto;				
				
				for (ProjectDTO project : projectManager.getProjectsManaged()) {
					if(projectId.equals(project.getProjectId())) {
						project.getProjectActivities().add(activity);
					}
				}
			}
		}			
		return projectManager;
	}

}
