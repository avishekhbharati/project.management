package sef.project.management.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY")
public class Activity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIVITY_ID", nullable = false)
	private Integer activityId;

	@Column(name = "ACTIVITY_NAME", nullable = false)
	private String activityName;

	@Column(name = "DEPENDENCY_ACTIVITY_ID", nullable = true)
	private Integer dependencyActivityId;

	@Column(name = "DAYS_REQUIRED", nullable = true)
	private Integer daysRequired;

	@Column(name = "START_DATE", nullable = true)
	private Timestamp startDate;

	@Column(name = "END_DATE", nullable = true)
	private Timestamp endDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

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

	public Integer getDaysRequired() {
		return daysRequired;
	}

	public void setDaysRequired(Integer daysRequired) {
		this.daysRequired = daysRequired;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
