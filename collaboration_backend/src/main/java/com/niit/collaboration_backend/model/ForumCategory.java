package com.niit.collaboration_backend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class ForumCategory {
	
	@Id
	@Column
	@GeneratedValue
	private String fcid;
	
	@Column
	@NotEmpty(message="Forum category should not be blank")
	private String forumcatname;
	
	
	public ForumCategory(){
		this.fcid = "FCT" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getId() {
		return fcid;
	}

	public void setId(String fcid) {
		this.fcid = fcid;
	}

	public String getForumcatname() {
		return forumcatname;
	}

	public void setForumcatname(String forumcatname) {
		this.forumcatname = forumcatname;
	}	
}
