package com.miniproject.linkedin.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.repository.ILinkedinRepository;

@Repository
public class LinkedinRepository implements ILinkedinRepository{
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int createAccount(InsertDataModel insertmodel) {
		var quser= "INSERT INTO user"
				+ "(firstname,lastname,email,collegeid,gradyear,genderid,contact) "
				+ "VALUES "
				+ "(?,?,?,?,?,?,?);";
		var qauthority= "INSERT INTO authority"
				+ "(userid,password) "
				+ "VALUES "
				+ "(?,?);";
		
		if(insertmodel.getCollegename() != null && !insertmodel.getCollegename().isEmpty()) {
			var qcollege= "INSERT INTO college"
					+ "(collegename)"
					+ "VALUES "
					+ "(?);";
			var qcount= "SELECT collegeid "
					+ "FROM college "
					+ "ORDER BY collegeid DESC "
					+ "LIMIT 1;";
			jdbc.update(qcollege, new Object[] {
					insertmodel.getCollegename()
			});
			insertmodel.setCollegeid(jdbc.queryForObject(qcount, Integer.class));
		}
		
		jdbc.update(quser,
				new Object[] {
					insertmodel.getFirstname(),
					insertmodel.getLastname(),
					insertmodel.getEmail(),
					insertmodel.getCollegeid(),
					insertmodel.getGradyear(),
					insertmodel.getGenderid(),
					insertmodel.getContact()
				});
		
		var quid= "SELECT userid "
				+ "FROM user "
				+ "ORDER BY userid DESC "
				+ "LIMIT 1;";
		var uid= jdbc.queryForObject(quid, Integer.class);
		jdbc.update(qauthority,
				new Object[] {
					uid,
					insertmodel.getPassword()
				});
		
		return 0;
	}

	@Override
	public int addUserSkill(InsertSkillModel insertmodel) {
		var quserskill= "INSERT INTO userskill"
				+ "(userid, skillid) "
				+ "VALUES "
				+ "(?,?);";
		var qskill= "INSERT INTO skill"
				+ "(skillname) "
				+ "VALUES "
				+ "(?)";
		
		switch(insertmodel.getSkillid()) {
		case 0:
			break;
		case 1:
			jdbc.update(qskill,
				new Object[] {
					insertmodel.getSkillname()
				});
			var qgetskillid= "SELECT skillid "
					+ "FROM skill "
					+ "ORDER BY skillid DESC "
					+ "LIMIT 1";
			insertmodel.setSkillid(jdbc.queryForObject(qgetskillid, Integer.class));
		default:
			jdbc.update(quserskill,
				new Object[] {
					insertmodel.getUserid(),
					insertmodel.getSkillid()
				});
		}
		return 0;
	}

}
