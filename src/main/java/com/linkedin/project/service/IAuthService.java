package com.linkedin.project.service;

public interface IAuthService {
	public String createAdmin(String username, String password, String authority);
	public String createUser(String username, String password, String authority);
}
