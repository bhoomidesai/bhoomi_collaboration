package com.niit.collaboration_backend.testfailes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaboration_backend.dao.UserProfileDAO;
import com.niit.collaboration_backend.model.UserProfile;

public class UserProfileJU {

	@Autowired
	UserProfileDAO userProfileDao;
	
	@Autowired
	UserProfile userProfile;
	
	AnnotationConfigApplicationContext context;
	private static final Logger log = LoggerFactory.getLogger(UserProfileJU.class);

	
	@Before
	public void init(){
		try{
			
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.collaboration_backend");
			context.refresh();
		
			userProfile =(UserProfile)context.getBean("userProfile");
			userProfileDao =  (UserProfileDAO)context.getBean("userProfileDao");
			
		}
		catch(Exception ex){
			log.debug("Error in code");
		}
	}
	
	@Test
	public void createUser()
	{
		//userProfile = new UserProfile();
		userProfile.setFstname("abc");
		userProfile.setLstname("aaa");
		userProfile.setCity("vadodara");
		userProfile.setGender("Female");
		userProfile.setMidname("xyz");
		userProfile.setMobileno("9087654321");
		userProfile.setUseremail("bhoomi@niit.com");
		userProfile.setUseridentity("Role_Student");
		userProfile.setUseronline('N');
		userProfile.setRegdate("2/2/2017");
		userProfile.setPassword("123123");
		userProfile.setApproved('A');
		userProfile.setDateofbirth("21/7/1994");
		userProfile.setLastmodifiedddate("2/2/2017");
		userProfile.setReason("no");
		userProfile.setAvtar("student");
		userProfile.setCurrentrole("student");
	
		assertEquals("createUser", userProfileDao.saveUserProfile(userProfile), true);
	}
}
