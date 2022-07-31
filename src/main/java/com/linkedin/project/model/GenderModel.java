package com.linkedin.project.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name= "gender")
public class GenderModel {
	@Id
	private int genderid;
	private String gendername;
}