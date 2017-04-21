package com.niit.collaboration_backend.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend.model.Job;
import com.niit.collaboration_backend.model.JobApplication;
import com.niit.collaboration_backend.model.UserProfile;

@EnableTransactionManagement
@Repository("jobDao")
public class JobDAO_Impl implements JobDAO {

	private static final Logger log = LoggerFactory.getLogger(BlogDAO_Impl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAO_Impl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean postjob(Job job) {
		try{
			sessionFactory.getCurrentSession().save(job);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean updatejob(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Job> getAllVacancies() {
		List<Job> allJobs = null;
		try{
			
			log.debug("Method => getAllVacancies() execution is starting");
			allJobs = sessionFactory.getCurrentSession().createQuery("FROM Job where status = 'A'").list();
			if(allJobs==null || allJobs.isEmpty()){
				log.debug("Record not found in Userrole table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allJobs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<JobApplication> getAlljobapp() {
		List<JobApplication> allJobs = null;
		try{
			
			log.debug("Method => getAllJobApp() execution is starting");
			allJobs = sessionFactory.getCurrentSession().createQuery("FROM JobApplication").list();
			if(allJobs==null || allJobs.isEmpty()){
				log.debug("Record not found in Userrole table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allJobs;
	}

	@Override
	@Transactional
	public boolean applyforjob(JobApplication jobapplication) {
		try{
			sessionFactory.getCurrentSession().save(jobapplication);
			sessionFactory.getCurrentSession().flush();
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean updatejobapplication(JobApplication jobapplication) {
		try{
			sessionFactory.getCurrentSession().update(jobapplication);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public JobApplication getJobApplication(String useremail, int jobid) {
		JobApplication obj =  (JobApplication) sessionFactory.getCurrentSession().createQuery("From JobApplication where useremail = '" + useremail 
								+ "' and jobid = " + jobid);
		return  obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<JobApplication> listAllAppliedJobs(String useremail) {
		List<JobApplication> allAppldJobs = null;
		try{
			
			log.debug("Method => getAllAppliedjob() execution is starting");
			allAppldJobs = sessionFactory.getCurrentSession().createQuery("FROM JobApplication where useremail = '" + 
					useremail + "'").list();
			if(allAppldJobs==null || allAppldJobs.isEmpty()){
				log.debug("Records are not found in Job applicatione table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allAppldJobs;
	}
	
	@Override
	@Transactional
	public boolean removeJob(int jobid) {
		boolean flag;
		String SQL = "Delete from Job where id = " + jobid;
		try{
			
			int res = sessionFactory.openStatelessSession().createQuery(SQL).executeUpdate();
			flag =  res == 1 ? true : false;
		}
		catch(HibernateException ex){
			flag=false;
		}
		return flag;
	}
	@Override
	@Transactional
	public boolean removeJobapp(int jobid) {
		boolean flag;
		String SQL = "Delete from JobApplication where id = " + jobid;
		try{
			
			int res = sessionFactory.openStatelessSession().createQuery(SQL).executeUpdate();
			flag =  res == 1 ? true : false;
		}
		catch(HibernateException ex){
			flag=false;
		}
		return flag;
	}
}