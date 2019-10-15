package sef.project.management.dto;

import java.util.List;

public class ActivityDTO {

	private Integer activityId;
	private String activityName;
	private Integer daysRequired;
	private Integer dependencyActivityId;
	private Integer startWeek;
	private Integer endWeek;
	private List<ActivitySkillDTO> requiredSkills;

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

	public Integer getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(Integer startWeek) {
		this.startWeek = startWeek;
	}

	public Integer getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	public List<ActivitySkillDTO> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<ActivitySkillDTO> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

}
