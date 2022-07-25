package com.miniproject.linkedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class SkillModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int skillid;
	public String skillname;

}
