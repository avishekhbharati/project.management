package sef.project.management.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(FullTimeDeveloperDetails.class)
@Table(name = "FULLTIMEDEVELOPER_DETAILS")
public class FullTimeDeveloperDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Id
	@Column(name = "BLOCKED_WEEKS", nullable = false)
	private Integer blockedweeks;

	@Id
	@Column(name = "SKILLS", nullable = false)
	private String skills;

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBlockedWeeks() {
		return blockedweeks;
	}

	public void setBlockedWeeks(Integer blockedweeks) {
		this.blockedweeks = blockedweeks;
	}
 
	public String getSkills() {
		return skills;
	}
	
	public void setSkills(String skills)
	{
		this.skills=skills;
	}

}
