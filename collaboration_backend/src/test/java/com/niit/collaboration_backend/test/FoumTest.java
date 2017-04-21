package com.niit.collaboration_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration_backend.dao.UserForumDAO;
import com.niit.collaboration_backend.model.JobApplication;
import com.niit.collaboration_backend.model.UserForum;
import com.niit.collaboration_backend.model.UserForumComments;

public class FoumTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static UserForumDAO userForumDao;
	private UserForum uf;
	private UserForumComments ufc;
//	private static final Logger log = LoggerFactory.getLogger(BlogTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		userForumDao =  (UserForumDAO)context.getBean("userForumDao",UserForumDAO.class);
	}
	
	@Test
	 public void listAllForums()
	 {
	  	assertEquals("fetched Successfully ",3, userForumDao.listAllForums().size());
	 }
	
	//@Test
	 public void addForum()
	 {
		uf=new UserForum();
		uf.setForumid(0);
		uf.setApprove('A');
		uf.setCreatedate(new Date().toString());
		uf.setDescription("from Test class");
		uf.setTitle("junit test");
		uf.setUseremail("bhoomi@niit.com");
		uf.setForumcategory("other");
	  	assertEquals("addForum Successfully ",true, userForumDao.addForum(uf));
	 }
	
	//@Test
	 public void getForumByID()
	 {
	  	assertEquals("got Successfully ",1, userForumDao.getForumByID(23).size());
	 }
	
	//@Test
	 public void listAllForumComments()
	 {
	  	assertEquals("got Successfully ",3, userForumDao.listAllForumComments(1).size());
	 }
	
	//@Test
	 public void updateApprove()
	 {
	  	assertEquals("updated Successfully ",true, userForumDao.updateApprove(69,'N'));
	 }
	
	//@Test
	 public void getUpdateLike()
	 {
	  	assertEquals("getUpdateLike Successfully ",true, userForumDao.getUpdateLike(69));
	 }
	
	//@Test
	 public void addForumComment()
	 {
		ufc=new UserForumComments();
		ufc.setComments("junit test comment");
		ufc.setDateofcomments(new Date().toString());
		ufc.setUseremail("b@niit.com");
		ufc.setId(0);
	  	assertEquals("addForumComment Successfully ",true, userForumDao.addForumComment(ufc));
	 }
	
	//@Test
	 public void deleteForum()
	 {
	  	assertEquals("deleteForum Successfully ",true, userForumDao.deleteForum(69));
	 }
	
	//@Test
	 public void deleteForumAdmin()
	 {
	  	assertEquals("deleteForumAdmin Successfully ",true, userForumDao.deleteForumAdmin(69));
	 }
}
