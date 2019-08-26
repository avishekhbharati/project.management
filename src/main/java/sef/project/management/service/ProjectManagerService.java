package sef.project.management.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import sef.project.management.entity.Activity;
import sef.project.management.entity.User;

@Service
public class ProjectManagerService {

	public Activity scheduleActivity(Activity activity, Timestamp startDate, Timestamp endDate) {
		if (activity != null && startDate != null && endDate != null) {
			if (endDate.getTime() > startDate.getTime()) {
				activity.setStartDate(startDate);
				activity.setEndDate(endDate);
			}
		}
		return activity;
	}

	public Activity setActivityDependency(Activity activity, Integer dependencyActivityId) {
		if (activity != null && activity.getActivityId() != dependencyActivityId) {
			activity.setDependencyActivityId(dependencyActivityId);
		}
		return activity;
	}
	
	public boolean allocateUserToActivity(Activity activity, User user, Timestamp startDate, Timestamp endDate) {
		boolean isAllocated = false;
//		if(activity !=null && user.) {
//			activity.setUser(user);
//			activity.setStartDate(startDate);
//			activity.setEndDate(endDate);
//		}
		return isAllocated;
	}

}
