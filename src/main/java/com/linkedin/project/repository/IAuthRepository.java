package com.linkedin.project.repository;

import com.linkedin.project.model.auth.UsersAuthenticationModel;
import com.linkedin.project.model.auth.UsersAuthoritiesModel;

public interface IAuthRepository {

	public String addUser(UsersAuthenticationModel authenticationModel);

	public String addRole(UsersAuthoritiesModel authorityModel);

}
