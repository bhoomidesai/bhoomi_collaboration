package com.niit.collaboration_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration_backend.dao.FriendsDAO;
import com.niit.collaboration_backend.model.Friends;

public class FriendsTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static FriendsDAO friendsDAO;
	private Friends friend;
//	private static final Logger log = LoggerFactory.getLogger(BlogTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		friendsDAO =  (FriendsDAO)context.getBean("friendsDAO",FriendsDAO.class);
	}
	
	//@Test
	 public void SaveFriendRequest()
	 {
		friend = new Friends();
		friend.setRequser("test@niit.com");
		friend.setTouser("b@niit.com");
		friend.setIsonline('Y');
		friend.setStatus('A');
		friend.setReqid(0);
		assertEquals("request Added", true,friendsDAO.saveRequest(friend));
	 }
	
	//@Test
	 public void getAllFriends()
	 {
	  	assertEquals("Friends fetched Successfully ",1, friendsDAO.listAllFriends("test@niit.com").size());
	 }
	
	//@Test
	 public void getFriend()
	 {
		friend =  friendsDAO.getFriend("radhi@niit.com","alice@niit.com");
	  	assertEquals("Friend fetched Successfully ", friendsDAO.getFriend(friend.getRequser(),friend.getTouser()).getRequser(),friend.getRequser());
	 }
	 
	//@Test
	 public void updateRequest()
	 {
	  	assertEquals("Friends updated Successfully ",true, friendsDAO.updateRequest(28,'A'));
	 }
	 
	//@Test
	 public void deleteFriend()
	 {
	  	assertEquals("Friends deleted Successfully ",true, friendsDAO.deleteFriend("test@niit.com","b@niit.com"));
	 }
	 
	// @Test
	 public void listRequestedFriends()
	 {
	  	assertEquals("Friends Fetched Successfully ",1, friendsDAO.listRequestedFriends("admin@niit.com").size());
	 }
	 
	 
	 // @Test
	 public void updateStatusOffOnline()
	 {
	  	assertEquals("Status updated Successfully ",true, friendsDAO.updateStatus("bhoomi@niit.com",'N'));
	 }

}
