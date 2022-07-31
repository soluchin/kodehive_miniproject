package com.linkedin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("/createaccount")
	public String createAccount() {
		return "createAccount";
	}
}
