package com.miniproject.linkedin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.service.ILinkedinService;

@Controller
public class ViewController {
	
	@Autowired
	ILinkedinService linkedinservice;

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
		accountModelList= linkedinservice.listAllAccount();
		model.addAttribute("user", accountModelList);
		return "/listAllAccount";
	}
}
