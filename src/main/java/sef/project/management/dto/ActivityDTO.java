package sef.project.management.dto;

import java.sql.Timestamp;
import java.util.List;

public class ActivityDTO {

	private Integer activityId;
	private String activityName;
	private Integer dependencyActivityId;
	private Timestamp startDate;
	private Timestamp endDate;
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

	public List<ActivitySkillDTO> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<ActivitySkillDTO> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

}
