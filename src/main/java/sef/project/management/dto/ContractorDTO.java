package sef.project.management.dto;

import java.util.ArrayList;
import java.util.List;

public class ContractorDTO extends UserDTO {

	private List<ContractorDetailsDTO> contractorDetails = new ArrayList<ContractorDetailsDTO>();

	public List<ContractorDetailsDTO> getContractorDetails() {
		return contractorDetails;
	}

	public void setContractorDetails(List<ContractorDetailsDTO> contractorDetails) {
		this.contractorDetails = contractorDetails;
	}

}
