package com.niit.collaboration_backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend.model.Blog;

@EnableTransactionManagement
@Repository("userBlogDao")
public class BlogDAO_Impl implements BlogDAO {

	private static final Logger log = LoggerFactory.getLogger(BlogDAO_Impl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAO_Impl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Blog> getAllBlogs() {
		List<Blog> allBlogs = null;
		try{
			
			log.debug("Method => getAllBlogs() execution is starting");
			allBlogs = sessionFactory.getCurrentSession().createQuery("FROM Blog").list();
			if(allBlogs==null || allBlogs.isEmpty()){
				log.debug("Record not found in Blog table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allBlogs;
	}

	@Override
	@Transactional
	public boolean saveUserBlog(Blog ubObj) {
		try
		{
			log.debug("Method => saveBlog() execution is starting");
			sessionFactory.getCurrentSession().save(ubObj);
			return true;
		}
		catch(HibernateException ex){
			log.debug("Data Save Error :" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateApprove(String blgid, char flag) {
		try{
			Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("update Blog set blogStatus = '" + flag + "' where blogId = '" + blgid+"'");
			return query.executeUpdate()==1 ? true : false;
		}
		catch(HibernateException ex){
			log.debug("Data update Error :" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Blog getBlogByID(String blgid) {
		try
		{
			log.debug("Method => getBlogByID() execution is starting");
			return (Blog) sessionFactory.getCurrentSession().get(Blog.class, blgid);
		}
		catch(HibernateException ex){
			log.debug("Data fetch Error :" + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public boolean getUpdateLike(String blgid) {
		try{
			Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("update Blog set blogLike = blogLike + 1 where blogId ='" + blgid+"'");
			boolean res =  query.executeUpdate()==1 ? true : false;
			log.debug("Result :" + res);
			return res;
		}
		catch(HibernateException ex){
			log.debug("Data update Error :" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean getDelete(String blgid) {
		try{
			Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("delete from Blog where blogId = '" + blgid+"'");
			return query.executeUpdate()==1 ? true : false;
		}
		catch(HibernateException ex){
			log.debug("Data delete Error :" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}
}
