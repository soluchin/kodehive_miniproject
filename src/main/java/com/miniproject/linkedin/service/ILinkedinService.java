package com.miniproject.linkedin.service;

import java.util.List;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.model.temp.ListAllUserSkillModel;
import com.miniproject.linkedin.model.temp.Wrapper;

public interface ILinkedinService {

	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);
	public List<ListAllAccountModel> listAllAccount();
	public List<CollegeModel> getCollegeData();
	public List<ListAllUserSkillModel> listAllSkill();
	public List<Integer> listAccountBySkill(Wrapper skills);
	public List<ListAllAccountModel> listAccountByUserid(Wrapper userid);
}
