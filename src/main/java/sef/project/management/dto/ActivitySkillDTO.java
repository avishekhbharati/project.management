package sef.project.management.dto;

public class ActivitySkillDTO {

	private Integer skillLevelRequired;
	private SkillDTO skill;

	public Integer getSkillLevelRequired() {
		return skillLevelRequired;
	}

	public void setSkillLevelRequired(Integer skillLevelRequired) {
		this.skillLevelRequired = skillLevelRequired;
	}

	public SkillDTO getSkill() {
		return skill;
	}

	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}

}
