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

	public ContractorDetails createContractor(Integer weeks, Integer rate) {
		ContractorDetails contractor = new ContractorDetails();
		contractor.setRate(rate);
		contractor.setWeeks(weeks);
		return contractor;
	}

	public List<ContractorDetails> addContractor(List<ContractorDetails> contractorDetailsList,
			ContractorDetails contractorDetails) {
		if (contractorDetailsList.size() > 0) {
			contractorDetailsList.add(contractorDetails);
		}
		return contractorDetailsList;
	}
}
