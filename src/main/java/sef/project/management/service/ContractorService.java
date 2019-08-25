package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.entity.ContractorDetails;
import sef.project.management.repository.ContractorDetailsRepository;

@Service
public class ContractorService {

	@Autowired
	private ContractorDetailsRepository contractorDetailsRepository;

	public List<ContractorDetails> getAllContractors(String name) {
		return contractorDetailsRepository.getContractorDetails(name);
	}

	public String sampleTest() {
		return "Test";
	}
}
