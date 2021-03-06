package com.niit.collaboration_backend.dao;

import java.util.List;

import com.niit.collaboration_backend.model.Job;
import com.niit.collaboration_backend.model.JobApplication;

public interface JobDAO {

	public boolean postjob(Job job);
	
	public boolean updatejob(Job job);
	
	public List<Job> getAllVacancies();
	
	public boolean applyforjob(JobApplication jobapplication);
	
	public boolean updatejobapplication(JobApplication jobapplication);
	
	public JobApplication getJobApplication(String useremail, int jobid);

	public List<JobApplication> listAllAppliedJobs(String useremail);
	public List<JobApplication> getAlljobapp();

	public boolean removeJob(int jobid);

	public boolean removeJobapp(int jobid);
}
