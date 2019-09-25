package sef.project.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sef.project.management.entity.FullTimeDeveloperDetails;

@Repository
public interface FullTimeDeveloperRepository extends CrudRepository<FullTimeDeveloperDetails, Integer> 
{

	@Query("select f from FullTimeDeveloperDetails f where f.user.userName=:name")
	public List<FullTimeDeveloperDetails> getFullTimeDeveloperDetails(String name);
		
}
