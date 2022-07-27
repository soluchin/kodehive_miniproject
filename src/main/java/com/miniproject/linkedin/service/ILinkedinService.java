package com.miniproject.linkedin.service;

import java.util.List;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;

public interface ILinkedinService {

	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);
	public List<ListAllAccountModel> listAllAccount();
	public List<CollegeModel> getCollegeData();
	
}
