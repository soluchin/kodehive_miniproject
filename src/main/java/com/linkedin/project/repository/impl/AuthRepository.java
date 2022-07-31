package com.linkedin.project.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.linkedin.project.model.auth.UsersAuthenticationModel;
import com.linkedin.project.model.auth.UsersAuthoritiesModel;
import com.linkedin.project.repository.IAuthRepository;

@Repository
public class AuthRepository implements IAuthRepository{
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public String addUser(UsersAuthenticationModel authenticationModel) {
		String q= "INSERT INTO authentication(username,password,enabled)"
				+ "VALUES ('"
				+ authenticationModel.getUsername() +"','"
				+ authenticationModel.getPassword() +"',"
				+ authenticationModel.getEnabled()
				+")";
		int status= jdbc.update(q);
		if(status == 1) {			
			return "success";
		}
		else {
			return "failed";
		}
	}

	@Override
	public String addRole(UsersAuthoritiesModel authorityModel) {
		String q= "INSERT INTO authorities(username, authority)"
				+ "VALUES ('"
				+ authorityModel.getUsername() +"','"
				+ authorityModel.getAuthority()+ "')";
		int status= jdbc.update(q);
		if(status == 1) {			
			return "success";
		}
		else {
			return "failed";
		}
	}

}
