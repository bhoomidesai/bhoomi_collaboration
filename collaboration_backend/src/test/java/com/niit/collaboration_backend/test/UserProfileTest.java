package com.niit.collaboration_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.niit.collaboration_backend.dao.UserProfileDAO;
import com.niit.collaboration_backend.model.UserProfile;
//@WebAppConfiguration
public class UserProfileTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static UserProfileDAO userProfileDao;
	private UserProfile userProfile;
//	private static final Logger log = LoggerFactory.getLogger(UserProfileTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		userProfileDao =  (UserProfileDAO)context.getBean("userProfileDao",UserProfileDAO.class);
		//userProfile =(UserProfile)context.getBean("userProfile");
	}
	
	//@Test
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

		assertEquals("created newUser", userProfileDao.saveUserProfile(userProfile), true);	
	}
	
	//@Test
	public void aprove()
	{
		userProfile=new UserProfile();
		//userProfile.setApproved('Y');
		assertEquals("user aproved", userProfileDao.updateApprove("test@niit.com", 'Y'), true);	
	}
	
	//@Test
	public void getAllUsers()
	{
		assertEquals("users received from DB", 8,userProfileDao.getAllUsers().size());
	}
	
	//@Test
	public void updateOnOffline()
	{
		userProfile = new UserProfile();
		assertEquals("user get by mail from DB", true, userProfileDao.updateOnOffLine("bhoomi@niit.com",'N'));
	}
	//@Test
	public void getUserProfileByEmail()
	{
		userProfile = userProfileDao.getUserProfileByEmail("bhoomi@niit.com");
		assertEquals("user get by mail from DB", userProfileDao.getUserProfileByEmail("bhoomi@niit.com").getUseremail(),userProfile.getUseremail());
	}
	
	//@Test
	public void checkUserEmail()
	{
		assertEquals("checkUserEmail success",true, userProfileDao.checkUserEmail("bhoomi@niit.com"));
	}
	
	//@Test
    public void isValidUser(){
		userProfile=new UserProfile();
		userProfile.setUseremail("admin@niit.com");
		userProfile.setPassword("123456");
                    UserProfile u = userProfileDao.authenticate(userProfile.getUseremail(),userProfile.getPassword());
                    assertEquals("isValidUser",userProfileDao.authenticate(userProfile.getUseremail(),userProfile.getPassword()).getUseremail(),u.getUseremail());
    }
	
}
