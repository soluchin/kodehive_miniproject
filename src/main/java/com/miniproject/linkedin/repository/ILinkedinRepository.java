package com.miniproject.linkedin.repository;

import java.util.List;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.SkillModel;
import com.miniproject.linkedin.model.UserModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.model.temp.ListAllUserSkillModel;
import com.miniproject.linkedin.model.temp.Wrapper;

public interface ILinkedinRepository {
	
	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);
	public List<ListAllAccountModel> listAllAccount();
	public List<CollegeModel> getCollegeData();
	public List<ListAllUserSkillModel> listAllSkill();
	public List<Integer> listAccountBySkill(Wrapper skills);
	public List<ListAllAccountModel> listAccountByUserid(Wrapper userid);
	public List<SkillModel> listAvailableSkill();
	public List<String> skillNameBySkillid(List<Integer> integers);
	public String deleteDataByUserid(int id);
	public String updateDataByUserid(UserModel usermodel);
}
