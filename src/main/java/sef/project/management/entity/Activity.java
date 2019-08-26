package sef.project.management.entity;

import java.sql.Timestamp;

public class Activity {

	private Integer activityId;

	private String activityName;

	private Integer daysRequired;

	private Integer dependencyActivityId;

	private Timestamp startDate;

	private Timestamp endDate;

	private User user;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getDaysRequired() {
		return daysRequired;
	}

	public void setDaysRequired(Integer daysRequired) {
		this.daysRequired = daysRequired;
	}

	public Integer getDependencyActivityId() {
		return dependencyActivityId;
	}

	public void setDependencyActivityId(Integer dependencyActivityId) {
		this.dependencyActivityId = dependencyActivityId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
