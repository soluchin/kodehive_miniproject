package com.linkedin.project.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	static public String generatePassword(String pass) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encoded= encoder.encode(pass);
		return encoded;
	}
}
