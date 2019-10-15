package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.dto.UserSkillDTO;
import sef.project.management.exception.NotFoundException;
import sef.project.management.service.SkillService;

@Controller
@RequestMapping(path = "/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping(path = "/list")
	public @ResponseBody List<SkillDTO> getAllSkills() {
		return skillService.getAllSkills();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody UserDTO addskill(@RequestParam Integer userId, @RequestBody UserSkillDTO userSkill) {
		try {
			return skillService.addSkill(userId, userSkill);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping(path = "/updatelevel")
	public @ResponseBody UserDTO addskill(@RequestParam Integer userId, @RequestParam Integer newSkillLevel, @RequestBody UserSkillDTO userSkill) {
		try {
			return skillService.updateSkillLevel(userId, newSkillLevel, userSkill);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping(path = "/create")
	public @ResponseBody List<SkillDTO> createSkill(@RequestBody SkillDTO skill) {
		return skillService.createSkill(skill);
	}
}
