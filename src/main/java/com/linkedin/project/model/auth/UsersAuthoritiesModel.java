package com.linkedin.project.model.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="authorities")
@NoArgsConstructor
@AllArgsConstructor
public class UsersAuthoritiesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authoritiesid;
	private String username;
	private String authority;
}
