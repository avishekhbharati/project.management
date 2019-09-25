package sef.project.management.dto;

import java.util.List;

public class ContractorDTO extends UserDTO {

	private List<ContractorDetailsDTO> contractorDetails;

	public List<ContractorDetailsDTO> getContractorDetails() {
		return contractorDetails;
	}

	public void setContractorDetails(List<ContractorDetailsDTO> contractorDetails) {
		this.contractorDetails = contractorDetails;
	}

}
