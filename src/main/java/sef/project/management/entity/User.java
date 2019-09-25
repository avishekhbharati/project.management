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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false)
	private Integer id;

	@Column(name = "USERNAME", nullable = false)
	private String userName;

	@Column(name = "EMAIL_ID", nullable = false)
	private String email;

	@Column(name = "ROLE", nullable = false)
	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ContractorDetails> contractorDetails = new ArrayList<ContractorDetails>();

	public ContractorDetails addContractorDetails(ContractorDetails contractorDetails) {
		contractorDetails.setUser(this);
		getContractorDetails().add(contractorDetails);
		return contractorDetails;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<FullTimeDeveloperDetails> fullTimeDeveloperDetails = new ArrayList<FullTimeDeveloperDetails>();
	
	public FullTimeDeveloperDetails addFullTimeDeveloperDetails(FullTimeDeveloperDetails fullTimeDeveloperDetails) {
		fullTimeDeveloperDetails.setUser(this);
		getFullTimeDeveloperDetails().add(fullTimeDeveloperDetails);
		return fullTimeDeveloperDetails;
	}

	@OneToMany(mappedBy = "allocatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projectsManaged = new ArrayList<Project>();

	public Project addProjectManaged(Project project) {
		project.setAllocatedBy(this);
		getProjectsManaged().add(project);
		return project;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserSkill> userSkills = new ArrayList<UserSkill>();

	public UserSkill addUserSkill(UserSkill userSkill) {
		userSkill.setUser(this);
		getUserSkills().add(userSkill);
		return userSkill;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ActivityAllocation> activityAllocations = new ArrayList<ActivityAllocation>();

	public ActivityAllocation addActivityAllocation(ActivityAllocation activityAllocation) {
		activityAllocation.setUser(this);
		getActivityAllocations().add(activityAllocation);
		return activityAllocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<ContractorDetails> getContractorDetails() {
		return contractorDetails;
	}

	public void setContractorDetails(List<ContractorDetails> contractorDetails) {
		this.contractorDetails = contractorDetails;
	}

	public List<FullTimeDeveloperDetails> getFullTimeDeveloperDetails() {
		return fullTimeDeveloperDetails;
	}

	public void setFullTimeDeveloperDetails(List<FullTimeDeveloperDetails> fullTimeDeveloperDetails) {
		this.fullTimeDeveloperDetails = fullTimeDeveloperDetails;
	}

	public List<Project> getProjectsManaged() {
		return projectsManaged;
	}

	public void setProjectsManaged(List<Project> projectsManaged) {
		this.projectsManaged = projectsManaged;
	}

	public List<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	public List<ActivityAllocation> getActivityAllocations() {
		return activityAllocations;
	}

	public void setActivityAllocations(List<ActivityAllocation> activityAllocations) {
		this.activityAllocations = activityAllocations;
	}

}