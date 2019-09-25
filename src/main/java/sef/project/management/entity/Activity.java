package sef.project.management.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ActivityAllocation> activityAllocations = new ArrayList<ActivityAllocation>();

	public ActivityAllocation addActivityAllocation(ActivityAllocation activityAllocation) {
		activityAllocation.setActivity(this);
		getActivityAllocations().add(activityAllocation);
		return activityAllocation;
	}

	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ActivitySkill> requiredSkills = new ArrayList<ActivitySkill>();

	public ActivitySkill addSkillRequired(ActivitySkill activitySkill) {
		activitySkill.setActivity(this);
		getRequiredSkills().add(activitySkill);
		return activitySkill;
	}

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

	public List<ActivityAllocation> getActivityAllocations() {
		return activityAllocations;
	}

	public void setActivityAllocations(List<ActivityAllocation> activityAllocations) {
		this.activityAllocations = activityAllocations;
	}

	public List<ActivitySkill> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<ActivitySkill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
}
