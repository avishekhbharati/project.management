package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.constants.Constants;
import sef.project.management.dto.FullTimeDeveloperDTO;
import sef.project.management.dto.FullTimeDeveloperDetailsDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.entity.FullTimeDeveloperDetails;

@Service
public class FullTimeDeveloperService {

	@Autowired
	private ProjectManagementService projectManagementService;

	public FullTimeDeveloperDetails createFullTimeDeveloper(Integer weeks, String skills) {
		FullTimeDeveloperDetails developer = new FullTimeDeveloperDetails();
		developer.setBlockedWeek(weeks);
		return developer;
	}

	public List<FullTimeDeveloperDetails> addFullTimeDeveloper(
			List<FullTimeDeveloperDetails> FullTimeDeveloperDetailsList,
			FullTimeDeveloperDetails FullTimeDeveloperDetails) {
		if (FullTimeDeveloperDetailsList.size() > 0) {
			FullTimeDeveloperDetailsList.add(FullTimeDeveloperDetails);
		}
		return FullTimeDeveloperDetailsList;
	}

	public FullTimeDeveloperDTO addAvailability(Integer userId, Integer week, Integer type) {
		FullTimeDeveloperDTO ftd = null;
		List<UserDTO> users = this.projectManagementService.getProjectMangement().getUsers();
		for (UserDTO user : users) {
			if (user.getRole().equalsIgnoreCase(Constants.ROLE_FULL_TIME_DEVELOPER) && user.getId().equals(userId)) {
				ftd = (FullTimeDeveloperDTO) user;
				FullTimeDeveloperDetailsDTO details = new FullTimeDeveloperDetailsDTO();
				details.setBlockedWeek(week);
				details.setBlockType(type);
				ftd.getFullTimeDeveloperDetails().add(details);
			}
		}
		return ftd;
	}
}