package sef.project.management.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import sef.project.management.dto.ActivityDTO;
import sef.project.management.entity.User;

@Service
public class ProjectManagerService {

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

}
