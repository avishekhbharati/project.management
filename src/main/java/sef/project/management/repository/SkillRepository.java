package sef.project.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sef.project.management.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

	@Query("select u from Skill u")
	public List<Skill> getSkills();
}
