package com.niit.collaboration_backend.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int roleid;
	
	@Column
	@NotEmpty(message="Role name should not be empty")
	private String rolename;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
