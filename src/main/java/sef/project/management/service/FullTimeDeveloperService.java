package sef.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sef.project.management.entity.FullTimeDeveloperDetails;
import sef.project.management.repository.FullTimeDeveloperRepository;

@Service
public class FullTimeDeveloperService {

	@Autowired
	private FullTimeDeveloperRepository fulltimedeveloperrepository;

	
	
	public List<FullTimeDeveloperDetails> getAllFullTimeDeveloperDetails(String name) {
		return fulltimedeveloperrepository.getFullTimeDeveloperDetails(name);
	}

	public FullTimeDeveloperDetails createFullTimeDeveloper(Integer weeks, String skills) {
		FullTimeDeveloperDetails developer = new FullTimeDeveloperDetails();
		developer.setBlockedWeeks(weeks);
		developer.setSkills(skills);
		return developer;
	}

	public List<FullTimeDeveloperDetails> addFullTimeDeveloper(List<FullTimeDeveloperDetails> FullTimeDeveloperDetailsList,
			FullTimeDeveloperDetails FullTimeDeveloperDetails) {
		if (FullTimeDeveloperDetailsList.size() > 0) {
			FullTimeDeveloperDetailsList.add(FullTimeDeveloperDetails);
		}
		return FullTimeDeveloperDetailsList;
	}
}