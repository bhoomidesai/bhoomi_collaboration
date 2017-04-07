package com.niit.collaboration_backend.testfailes;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaboration_backend.dao.UserProfileDAO;
import com.niit.collaboration_backend.model.UserProfile;

public class UserProfileTest 
{
	private static 	AnnotationConfigApplicationContext context;
	@Autowired
	private static UserProfileDAO userDAO;
	@Autowired
	private UserProfile userProfile;
//	private static final Logger log = LoggerFactory.getLogger(UserProfileTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		userDAO =  (UserProfileDAO)context.getBean("userDAO",UserProfileDAO.class);
		//userProfile =(UserProfile)context.getBean("userProfile");
	}
	
	@Test
	public void createUser()
	{	
		userProfile = new UserProfile();
		userProfile.setFstname("abc");
		userProfile.setLstname("aaa");
		userProfile.setCity("vadodara");
		userProfile.setGender("Female");
		userProfile.setMidname("xyz");
		userProfile.setMobileno("9087654321");
		userProfile.setUseremail("test@niit.com");
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

		assertEquals("createUser", userDAO.saveUserProfile(userProfile), true);	
	}
}
