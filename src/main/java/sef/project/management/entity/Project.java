package sef.project.management.entity;

import java.io.Serializable;
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
@Table(name = "PROJECT")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID", nullable = false)
	private Integer projectId;
	
	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ALLOCATED_BY")
	private User allocatedBy;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Activity> projectActivities = new ArrayList<Activity>();

	public Activity addActivity(Activity activity) {
		activity.setProject(this);
		getProjectActivities().add(activity);
		return activity;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public User getAllocatedBy() {
		return allocatedBy;
	}

	public void setAllocatedBy(User allocatedBy) {
		this.allocatedBy = allocatedBy;
	}

	public List<Activity> getProjectActivities() {
		return projectActivities;
	}

	public void setProjectActivities(List<Activity> projectActivities) {
		this.projectActivities = projectActivities;
	}
}
