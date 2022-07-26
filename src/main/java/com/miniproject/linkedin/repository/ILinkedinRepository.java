package com.miniproject.linkedin.repository;

import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;

public interface ILinkedinRepository {

	public int createAccount(InsertDataModel insertmodel);
	public int addUserSkill(InsertSkillModel insertmodel);

}
