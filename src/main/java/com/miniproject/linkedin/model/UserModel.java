package com.miniproject.linkedin.model;

import java.sql.Date;

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
	private String username;
	private int collegeid;
	private Date gradyear;
	private int genderid;
	private String contact;
	private int skill1id;
	private int skill2id;
	private int skill3id;
}
