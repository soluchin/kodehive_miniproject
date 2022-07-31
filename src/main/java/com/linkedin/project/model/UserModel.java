package com.linkedin.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "user")
public class UserModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private int collegeid;
	private int gradyear;
	private int genderid;
	private String contact;
}