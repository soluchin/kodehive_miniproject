package com.miniproject.linkedin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.SkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.model.temp.ListAllUserSkillModel;
import com.miniproject.linkedin.model.temp.Wrapper;
import com.miniproject.linkedin.repository.ILinkedinRepository;
import com.miniproject.linkedin.service.ILinkedinService;

@Controller
public class ViewController {
	
	@Autowired
	ILinkedinService linkedinservice;
	
	@Autowired
	ILinkedinRepository linkedinrepository;

	@RequestMapping("/createaccount")
	public String createAccount(Model model) {
		List<CollegeModel> collegeModelList= new ArrayList<CollegeModel>();
		collegeModelList= linkedinservice.getCollegeData();
		model.addAttribute("collegeData", collegeModelList);
		return "/createAccount";
	}
	
	@GetMapping("/listallaccount")
	public String listAllAccount(Model model) {
		List<ListAllAccountModel> accountModelList= new ArrayList<ListAllAccountModel>();
		List<ListAllUserSkillModel> skillStringList= new ArrayList<ListAllUserSkillModel>();
		List<SkillModel> allSkill= new ArrayList<SkillModel>();
		
		accountModelList= linkedinservice.listAllAccount();
		skillStringList= linkedinservice.listAllSkill();
		allSkill = linkedinservice.listAvailableSkill();
		
		model.addAttribute("user", accountModelList);
		model.addAttribute("skills", skillStringList);
		model.addAttribute("allskills", allSkill);
		
		return "/listAllAccount";
	}
	
	@PostMapping("listaccountbyskill")
	public String listAccountBySkill(Model model, @RequestBody Wrapper skills) {
		List<Integer> useridBySkill= linkedinservice.listAccountBySkill(skills);
		Wrapper wrapperUseridBySkill= new Wrapper();
		wrapperUseridBySkill.setIntegers(useridBySkill);
		
		List<ListAllAccountModel> accountByUserid= new ArrayList<ListAllAccountModel>();
		List<ListAllUserSkillModel> skillStringList= new ArrayList<ListAllUserSkillModel>();
		List<String> searchingSkills= new ArrayList<String>();
		
		accountByUserid= linkedinservice.listAccountByUserid(wrapperUseridBySkill);
		skillStringList= linkedinservice.listAllSkill();
		searchingSkills= linkedinrepository.skillNameBySkillid(skills.getIntegers());
		
		model.addAttribute("user", accountByUserid);
		model.addAttribute("skills", skillStringList);
		model.addAttribute("searchingfor", searchingSkills);
		
		return "/listAccountBySkill";
	}
}
