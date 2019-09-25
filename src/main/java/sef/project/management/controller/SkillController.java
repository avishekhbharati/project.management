package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.dto.SkillDTO;
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
}
