package sef.project.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sef.project.management.entity.ContractorDetails;
import sef.project.management.service.ContractorService;

@Controller
@RequestMapping(path = "/contractor")
public class ContractorController {

	@Autowired
	private ContractorService contractorService;

	@GetMapping(path = "/rates")
	public @ResponseBody List<ContractorDetails> getAllUsers(@RequestParam String name) {
		return contractorService.getAllContractors(name);
	}
}
