package com.miniproject.linkedin.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.miniproject.linkedin.model.CollegeModel;
import com.miniproject.linkedin.model.SkillModel;
import com.miniproject.linkedin.model.UserModel;
import com.miniproject.linkedin.model.temp.InsertDataModel;
import com.miniproject.linkedin.model.temp.InsertSkillModel;
import com.miniproject.linkedin.model.temp.ListAllAccountModel;
import com.miniproject.linkedin.model.temp.ListAllUserSkillModel;
import com.miniproject.linkedin.model.temp.Wrapper;
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

	@Override
	public List<ListAllAccountModel> listAllAccount() {
		var q= "SELECT u.userid AS userid, "
				+ "CONCAT_WS(' ', u.firstname, u.lastname) AS name, "
				+ "g.gendername AS gender, "
				+ "c.collegename AS college, "
				+ "u.gradyear AS gradyear "
				+ "FROM user AS u "
				+ "JOIN gender AS g ON u.genderid = g.genderid "
				+ "JOIN college AS c ON u.collegeid = c.collegeid ";
		var result= jdbc.query(q, new BeanPropertyRowMapper<ListAllAccountModel>(ListAllAccountModel.class));
		return result;
	}

	@Override
	public List<ListAllUserSkillModel> listAllSkill() {
		var q= "SELECT us.userid AS userid, "
				+ "s.skillname AS skillname, "
				+ "s.skillid AS skillid "
				+ "FROM userskill AS us "
				+ "JOIN skill AS s ON us.skillid=s.skillid;";
		var result= jdbc.query(q, new BeanPropertyRowMapper<ListAllUserSkillModel>(ListAllUserSkillModel.class));
		return result;
	}

	@Override
	public List<CollegeModel> getCollegeData() {
		var q= "SELECT collegeid, collegename "
				+ "FROM college";
		var result= jdbc.query(q, new BeanPropertyRowMapper<CollegeModel>(CollegeModel.class));
		return result;
	}

	@Override
	public List<Integer> listAccountBySkill(Wrapper skills) {
		var listuserid= skills.getIntegers();
		String strskills = listuserid.stream().map(String::valueOf).collect(Collectors.joining(","));
		var q= "SELECT userid "
				+ "FROM userskill AS us "
				+ "JOIN skill AS s ON us.skillid = s.skillid "
				+ "WHERE s.skillid IN ("+strskills+") "
				+ "GROUP BY userid";
		var result = jdbc.query(q, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
			
		});
		return result;
	}

	@Override
	public List<ListAllAccountModel> listAccountByUserid(Wrapper userid) {
		var listuserid= userid.getIntegers();
		String struserid = listuserid.stream().map(String::valueOf).collect(Collectors.joining(","));
		var q= "SELECT u.userid AS userid, "
				+ "CONCAT_WS(' ', u.firstname, u.lastname) AS name, "
				+ "g.gendername AS gender, "
				+ "c.collegename AS college, "
				+ "u.gradyear AS gradyear "
				+ "FROM user AS u "
				+ "JOIN gender AS g ON u.genderid = g.genderid "
				+ "JOIN college AS c ON u.collegeid = c.collegeid "
				+ "WHERE userid IN ("+ struserid+")";
		var result= jdbc.query(q, new BeanPropertyRowMapper<ListAllAccountModel>(ListAllAccountModel.class));
		return result;
	}

	@Override
	public List<SkillModel> listAvailableSkill() {
		var q= "SELECT * FROM skill";
		return jdbc.query(q, new BeanPropertyRowMapper<SkillModel>(SkillModel.class));
	}

	@Override
	public List<String> skillNameBySkillid(List<Integer> integers) {
		String skillid = integers.stream().map(String::valueOf).collect(Collectors.joining(","));
		var q= "SELECT skillname FROM skill WHERE skillid IN ("+ skillid+")";
		return jdbc.query(q, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
			
		});
	}

	@Override
	public String deleteDataByUserid(int id) {
		var quser= "DELETE FROM user WHERE userid = "+id;
		var quserskill= "DELETE FROM userskill WHERE userid = "+id;
		var qauthority= "DELETE FROM authority WHERE userid = "+id;
		jdbc.update(quser);
		jdbc.update(quserskill);
		jdbc.update(qauthority);
		return "success";
	}

	@Override
	public String updateDataByUserid(UserModel usermodel) {
		var q= "UPDATE user "
				+ "SET ";
		if(usermodel.getFirstname()!= null) {
			q= q+"firstname = '" + usermodel.getFirstname()+"' ";
		}
		if(usermodel.getLastname()!= null) {
			q= q+"lastname = '" + usermodel.getLastname()+"' ";
		}
		if(usermodel.getContact()!= null) {
			q= q+"contact = '" + usermodel.getContact()+"' ";
		}
		q= q+"WHERE userid = "+usermodel.getUserid();
		jdbc.update(q);
		return "success";
	}


}
