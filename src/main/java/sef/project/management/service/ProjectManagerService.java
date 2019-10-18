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
		if(!validateActivity(activityAllocation)) return new UserDTO();
		ActivityDTO activity = null;
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();
		for (UserDTO userDto : userList) {
			if (Constants.ROLE_PROJECT_MANAGER.equals(userDto.getRole())) {
				ProjectManagerDTO projectManager = (ProjectManagerDTO) userDto;
				for (ProjectDTO project : projectManager.getProjectsManaged()) {
					if (projectId.equals(project.getProjectId())) {
						for (ActivityDTO a : project.getProjectActivities()) {
							if (activityId.equals(a.getActivityId())) {
								activity = a;
								activityAllocation.setActivity(activity);
							}
						}
					}
				}
			}
		}
		if (activity == null)
			return null;
		return setActivityAllocation(userId, userList, activityAllocation);
	}
	
	public boolean validateActivity(ActivityAllocationDTO activityAllocation) {
		if(activityAllocation.getStartWeek()>52 || activityAllocation.getStartWeek()<1 || activityAllocation.getEndWeek()>52 || activityAllocation.getEndWeek()<1) return false;
		else return true;
	}
	
	public UserDTO setActivityAllocation(Integer userId,List<UserDTO> userList,ActivityAllocationDTO activityAllocation) {
		UserDTO user = null;
		for (UserDTO userDto : userList) {
			if (userId.equals(userDto.getId())) {
				userDto.getActivityAllocations().add(activityAllocation);
				user = userDto;
			}
		}
		return user;
	}

	public ProjectManagerDTO createProject(Integer userId, ProjectDTO project) {
		List<UserDTO> userList = projectManagementService.getProjectMangement().getUsers();
		ProjectManagerDTO projectManager = null;
		for (UserDTO userDto : userList) {
			if (userId.equals(userDto.getId())) {
				projectManager = (ProjectManagerDTO) userDto;
				projectManager.getProjectsManaged().add(project);
			}
		}
		return projectManager;
	}

}
