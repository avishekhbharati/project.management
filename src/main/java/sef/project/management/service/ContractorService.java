package sef.project.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.constants.Constants;
import sef.project.management.dto.ContractorDTO;
import sef.project.management.dto.ContractorDetailsDTO;
import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.ContractorDetails;

@Service
public class ContractorService {

	@Autowired
	private ProjectManagementService projectManagementService;
	
	public List<ContractorDTO> getAllContractors() {
		List<UserDTO> users = projectManagementService.getProjectMangement().getUsers();
		List<ContractorDTO> contractors = new ArrayList<ContractorDTO>();
		for (UserDTO user : users) {
			if (user.getRole().equals(Constants.ROLE_CONTRACTOR)) {
				contractors.add((ContractorDTO) user);
			}
		}
		return contractors;
	}

	public ContractorDTO createContractor(Integer weeks, Integer rate) {
		ContractorDTO contractorDTO = new ContractorDTO();
		ContractorDetailsDTO contractorDetails = new ContractorDetailsDTO();
		contractorDetails.setRate(rate);
		contractorDetails.setWeeks(weeks);
		contractorDTO.getContractorDetails().add(contractorDetails);
		contractorDTO.setUserName("Test");
		//TODO set other details
		projectManagementService.getProjectMangement().getUsers().add(contractorDTO);
		return contractorDTO;
	}

	public List<ContractorDetails> addContractor(List<ContractorDetails> contractorDetailsList,
			ContractorDetails contractorDetails) {
		if (contractorDetailsList.size() > 0) {
			contractorDetailsList.add(contractorDetails);
		}
		return contractorDetailsList;
	}

}
