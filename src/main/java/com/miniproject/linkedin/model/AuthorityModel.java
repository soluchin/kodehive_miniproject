package com.miniproject.linkedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "authority")
public class AuthorityModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int authorityid;
	private int userid;
	private String password;

}
