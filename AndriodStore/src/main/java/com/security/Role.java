package com.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(targetEntity =User.class,  mappedBy = "role",
			fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	private Set<User> users;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
