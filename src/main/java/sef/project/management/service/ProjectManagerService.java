package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.constants.Constants;
import sef.project.management.dto.ActivityAllocationDTO;
import sef.project.management.dto.ActivityDTO;
import sef.project.management.dto.ProjectDTO;
import sef.project.management.dto.ProjectManagerDTO;
import sef.project.management.dto.UserDTO;

@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagementService projectManagementService;

	public ProjectManagerDTO addActivityToProject(Integer projectManagerId, Integer projectId, ActivityDTO activity) {
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();
		ProjectManagerDTO projectManager = null;
		for (UserDTO userDto : userList) {
			if (projectManagerId.equals(userDto.getId())) {
				projectManager = (ProjectManagerDTO) userDto;
				for (ProjectDTO project : projectManager.getProjectsManaged()) {
					if (projectId.equals(project.getProjectId())) {
						project.getProjectActivities().add(activity);
					}
				}
			}
		}
		return projectManager;
	}

	public UserDTO allocateActivity(Integer userId, Integer projectId, Integer activityId,
			ActivityAllocationDTO activityAllocation) {
		ActivityDTO activity = null;
		UserDTO user = null;
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();
		for (UserDTO userDto : userList) {
			if (Constants.ROLE_PROJECT_MANAGER.equals(userDto.getRole())) {
				ProjectManagerDTO projectManager = (ProjectManagerDTO) userDto;
				for (ProjectDTO project : projectManager.getProjectsManaged()) {
					if (projectId.equals(project.getProjectId())) {
						for (ActivityDTO a : project.getProjectActivities()) {
							if(activityId.equals(a.getActivityId())) {
								activity = a;
							}
						}
					}
				}
			}
		}
		if(activity==null) return null;
		activityAllocation.setActivity(activity);
		for (UserDTO userDto : userList) {
			if (userId.equals(userDto.getId())) {
				userDto.getActivityAllocations().add(activityAllocation);
				user = userDto;
			}
		}
		return user;
	}

}
