package com.miniproject.linkedin.model.temp;

import java.sql.Date;
import java.time.Year;

import lombok.Data;

@Data
public class InsertDataModel {
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int collegeid;
	private String collegename;
	private int gradyear;
	private int genderid;
	private String contact;
}
