/*package com.niit.collaboration_backend.testfailes;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaboration_backend.dao.*;
import com.niit.collaboration_backend.model.*;



public class Test {
	
	AnnotationConfigApplicationContext context;
	
	public Test()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
	}
	
	public void createUser(UserProfile user)
	{
		
		UserProfileDAO  userDAO =  (UserProfileDAO) context.getBean("userProfileDao");
		userDAO.saveUserProfile(user);
		
	}
	
	public static void main(String[] args)
	{	
		Test t = new Test();
		
		UserProfile user =(UserProfile) t.context.getBean("userprofile");
		user.setFstname("abc");
		user.setLstname("aaa");
		user.setCity("vadodara");
		user.setGender("Female");
		user.setMidname("xyz");
		user.setMobileno("9087654321");
		user.setUseremail("bhoomi@niit.com");
		user.setUseridentity("student");
		user.setUseronline('N');
		user.setRegdate("2/2/2017");
		user.setPassword("123");
		user.setApproved('A');
		user.setDateofbirth("21/7/1994");
		user.setLastmodifiedddate("2/2/2017");
		user.setReason("no");
		//Test.createUser(user);
	}
}*/