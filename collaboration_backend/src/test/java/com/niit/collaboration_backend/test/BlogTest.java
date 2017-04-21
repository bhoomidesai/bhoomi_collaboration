package com.niit.collaboration_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration_backend.dao.BlogDAO;
import com.niit.collaboration_backend.model.Blog;

public class BlogTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static BlogDAO userBlogDao;
	private Blog blog;
//	private static final Logger log = LoggerFactory.getLogger(BlogTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		userBlogDao =  (BlogDAO)context.getBean("userBlogDao",BlogDAO.class);
		//userProfile =(UserProfile)context.getBean("userProfile");
	}
	
	 @Test
	 public void saveBlog()
	 {
	  blog = new Blog();
	  blog.setBlogCreatedAt(new Date().toString());
	  blog.setBlogId("22");
	  blog.setApprovalStatus('N');
	  blog.setBlogTitle("Test class");
	  blog.setUseremail("test@niit.com");
	  blog.setBlogDescription("This Blog is added through Test");
	  assertEquals("Blog Added Successfully ",true, userBlogDao.saveUserBlog(blog));
	 }
	@Test
	 public void updateApproveBlog()
	 {
	  	assertEquals("approved Successfully ",true, userBlogDao.updateApprove("22", 'N'));
	 }

	@Test
	 public void getAllBlogs()
	 {
	  	assertEquals("Blog fetched Successfully ",5, userBlogDao.getAllBlogs().size());
	 }
	
	@Test
	 public void getById()
	 {
		blog= userBlogDao.getBlogByID("BLGC6C3CD");
		assertEquals("Blog fetched Successfully ",userBlogDao.getBlogByID("BLGC6C3CD").getBlogId(),blog.getBlogId());
	 }
	 
	 @Test
	 public void updateLikes()
	 {
		assertEquals("Blog fetched Successfully ",true, userBlogDao.getUpdateLike("BLGC6C3CD"));
	 }
	 @Test
	 public void deleteBlog()
	 {
		assertEquals("Blog deleted Successfully ",true, userBlogDao.getDelete("22"));
	 }
	 

}
