package com.miniproject.linkedin.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.service.ILinkedinService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ILinkedinService linkedinservice;
	
	@PostMapping("/createaccount")
	public String createAccount(@RequestBody InsertDataModel insertmodel) {
		linkedinservice.createAccount(insertmodel);
		return "account created";
	}
	
	@PostMapping("/adduserskill")
	public String addUserSkill(@RequestBody InsertSkillModel insertmodel) {
		linkedinservice.addUserSkill(insertmodel);
		return "skill added";
	}
}
