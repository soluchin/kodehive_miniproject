package com.linkedin.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "college")
public class CollegeModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int collegeid;
	public String collegename;

}