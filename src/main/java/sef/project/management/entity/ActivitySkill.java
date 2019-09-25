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
@IdClass(ActivitySkill.class)
@Table(name = "ACTIVITY_SKILL")
public class ActivitySkill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACTIVITY_ID", nullable = false)
	private Activity activity;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SKILL_ID", nullable = false)
	private Skill skill;

	@Id
	@Column(name = "SKILL_LEVEL", nullable = false)
	private Integer skillLevel;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}
}
