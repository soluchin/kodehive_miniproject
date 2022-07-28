package com.miniproject.linkedin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.model.temp.ListAllUserSkillModel;
import com.miniproject.linkedin.model.temp.Wrapper;
import com.miniproject.linkedin.repository.ILinkedinRepository;
import com.miniproject.linkedin.service.ILinkedinService;

@Service
public class LinkedinService implements ILinkedinService{
	
	@Autowired
	ILinkedinRepository linkedinrepository;

	@Override
	public int createAccount(InsertDataModel insertmodel) {
		linkedinrepository.createAccount(insertmodel);
		return 0;
	}

	@Override
	public int addUserSkill(InsertSkillModel insertmodel) {
		linkedinrepository.addUserSkill(insertmodel);
		return 0;
	}

	@Override
	public List<ListAllAccountModel> listAllAccount() {
		var result= linkedinrepository.listAllAccount();
		return result;
	}

	@Override
	public List<ListAllUserSkillModel> listAllSkill() {
		var result= linkedinrepository.listAllSkill();
		return result;
	}

	@Override
	public List<CollegeModel> getCollegeData() {
		return linkedinrepository.getCollegeData();
	}

	@Override
	public List<Integer> listAccountBySkill(Wrapper skills) {
		return linkedinrepository.listAccountBySkill(skills);
	}

	@Override
	public List<ListAllAccountModel> listAccountByUserid(Wrapper userid) {
		return linkedinrepository.listAccountByUserid(userid);
	}


}
