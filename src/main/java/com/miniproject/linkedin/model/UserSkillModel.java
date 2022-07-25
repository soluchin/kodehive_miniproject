package com.miniproject.linkedin.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "userskill")
public class UserSkillModel {
	public int userid;
	public int skillid;
}
