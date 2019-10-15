package sef.project.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.dto.FullTimeDeveloperDTO;
import sef.project.management.service.FullTimeDeveloperService;

@Controller
@RequestMapping(path = "/fulltimedeveloper")
public class FullTimeDeveloperController {

	@Autowired
	private FullTimeDeveloperService fulltimedeveloperservice;
	
	@GetMapping(path = "/addavailability")
	public @ResponseBody FullTimeDeveloperDTO addAvailability(@RequestParam Integer userId, @RequestParam Integer week, @RequestParam Integer type) {
		return fulltimedeveloperservice.addAvailability(userId,week,type);
	}
	
}