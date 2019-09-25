package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.entity.FullTimeDeveloperDetails;
import sef.project.management.service.FullTimeDeveloperService;

@Controller
@RequestMapping(path = "/fulltimedeveloper")
public class FullTimeDeveloperController {

	@Autowired
	private FullTimeDeveloperService fulltimedeveloperservice;
	
	
	@GetMapping(path = "/dates")
	public @ResponseBody List<FullTimeDeveloperDetails> getAllUsers(@RequestParam String name) {
		return fulltimedeveloperservice.getAllFullTimeDeveloperDetails(name);
	}
	

}