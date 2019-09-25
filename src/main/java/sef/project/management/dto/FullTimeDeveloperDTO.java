package sef.project.management.dto;

import java.util.List;

public class FullTimeDeveloperDTO extends UserDTO {

	List<FullTimeDeveloperDetailsDTO> fullTimeDeveloperDetails;

	public List<FullTimeDeveloperDetailsDTO> getFullTimeDeveloperDetails() {
		return fullTimeDeveloperDetails;
	}

	public void setFullTimeDeveloperDetails(List<FullTimeDeveloperDetailsDTO> fullTimeDeveloperDetails) {
		this.fullTimeDeveloperDetails = fullTimeDeveloperDetails;
	}
}
