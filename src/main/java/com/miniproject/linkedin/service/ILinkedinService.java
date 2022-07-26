package com.miniproject.linkedin.service;

import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;

public interface ILinkedinService {

	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);
	
}
