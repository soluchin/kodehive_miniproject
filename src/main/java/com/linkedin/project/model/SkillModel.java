package com.linkedin.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "skill")
public class SkillModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int skillid;
	public String skillname;

}