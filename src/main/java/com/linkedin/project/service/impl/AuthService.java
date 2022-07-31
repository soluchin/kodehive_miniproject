package com.linkedin.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.project.model.auth.UsersAuthenticationModel;
import com.linkedin.project.model.auth.UsersAuthoritiesModel;
import com.linkedin.project.repository.IAuthRepository;
import com.linkedin.project.security.PasswordGenerator;
import com.linkedin.project.service.IAuthService;

@Service
public class AuthService implements IAuthService {
	
	@Autowired
	IAuthRepository authrepository;

	@Override
	public String createAdmin(String username, String password, String authority) {
		UsersAuthenticationModel authenticationModel= new UsersAuthenticationModel();
		UsersAuthoritiesModel authorityModel= new UsersAuthoritiesModel();
		
		String encoded= PasswordGenerator.generatePassword(password);
		
		authenticationModel.setUsername(username);
		authenticationModel.setPassword(encoded);
		authenticationModel.setEnabled(true);
		
		authorityModel.setUsername(username);
		authorityModel.setAuthority("ROLE_ADMIN");
		
		
		authrepository.addUser(authenticationModel);
		authrepository.addRole(authorityModel);
		return "new admin created";
	}
	
	public String createUser(String username, String password, String authority) {
		UsersAuthenticationModel authenticationModel= new UsersAuthenticationModel();
		UsersAuthoritiesModel authorityModel= new UsersAuthoritiesModel();
		
		String encoded= PasswordGenerator.generatePassword(password);
		
		authenticationModel.setUsername(username);
		authenticationModel.setPassword(encoded);
		authenticationModel.setEnabled(true);
		
		authorityModel.setUsername(username);
		authorityModel.setAuthority("ROLE_USER");
		
		
		authrepository.addUser(authenticationModel);
		authrepository.addRole(authorityModel);
		return "new user created";
	}

}
