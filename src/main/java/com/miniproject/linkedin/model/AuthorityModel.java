package com.miniproject.linkedin.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "authority")
public class AuthorityModel {
	public int userid;
	public String password;
}
