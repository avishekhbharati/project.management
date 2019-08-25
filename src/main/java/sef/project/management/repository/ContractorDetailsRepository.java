package sef.project.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sef.project.management.entity.ContractorDetails;

@Repository
public interface ContractorDetailsRepository extends CrudRepository<ContractorDetails, Integer> {

	@Query("select c from ContractorDetails c where c.user.userName=:name")
	public List<ContractorDetails> getContractorDetails(String name);
}
