package com.niit.collaboration_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration_backend.dao.JobDAO;
import com.niit.collaboration_backend.model.Job;
import com.niit.collaboration_backend.model.JobApplication;

public class JobTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static JobDAO jobDao;
	private Job job;
	private JobApplication jobapp;
//	private static final Logger log = LoggerFactory.getLogger(BlogTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		jobDao =  (JobDAO)context.getBean("jobDao",JobDAO.class);
	}
	//@Test
	public void SaveFriendRequest()
	{
		job=new Job();
		job.setCompanyname("Junit");
		job.setDescription("by test class");
		job.setExperience("2");
		job.setId(0);
		job.setLocation("Baroda");
		job.setPostdate(new Date().toString());
		job.setQualification("BE-IT");
		job.setStatus('A');
		job.setTitle("Junit Test");
		assertEquals("job Added", true,jobDao.postjob(job));

	}
	
	
	//@Test
	 public void getAllVacancies()
	 {
	  	assertEquals("applied jobs fetched Successfully ",3, jobDao.getAllVacancies().size());
	 }
	
	//@Test
	 public void getAlljobapp()
	 {
	  	assertEquals("all jobs fetched Successfully ",5, jobDao.getAlljobapp().size());
	 }
	
	
	//@Test
	 public void applyforjob()
	 {	
		jobapp=new JobApplication();
		jobapp.setId(0);
		jobapp.setJob_id(11);
		jobapp.setUseremail("b@niit.com");
	  	assertEquals("jobs saved Successfully ",true, jobDao.applyforjob(jobapp));
	 }
	

		// @Test
		 public void listAllAppliedJobs()
		 {
			  	assertEquals("applied jobs by user fetched Successfully ",2, jobDao.listAllAppliedJobs("bhoomi@niit.com").size()); 
		 }
		 
		// @Test
		 public void removeJob()
		 {
			  	assertEquals("job deleted Successfully ",true, jobDao.removeJob(64)); 
		 }
		 
		// @Test
		 public void removeJobapp()
		 {
			  	assertEquals("jobapplication deleted Successfully ",true, jobDao.removeJobapp(65)); 
		 }
	 
	
}
