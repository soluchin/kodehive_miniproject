package com.miniproject.linkedin.repository;

import java.util.List;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;

public interface ILinkedinRepository {
	
	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);
	public List<ListAllAccountModel> listAllAccount();
	public List<CollegeModel> getCollegeData();
}
