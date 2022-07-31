package com.linkedin.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "userskill")
public class UserSkillModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int rownumber;
	private int userid;
	private int skillid;
}