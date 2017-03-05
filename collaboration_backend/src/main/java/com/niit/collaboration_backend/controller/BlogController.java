package com.niit.collaboration_backend.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration_backend.dao.BlogDAO;
import com.niit.collaboration_backend.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDAO service;
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);

	@RequestMapping(value = "/adduserblog/", method = RequestMethod.POST)
	public ResponseEntity<Blog> createUserBlog(@RequestBody Blog ublog, HttpSession session)
	{
		log.debug("calling => createUserBlog() method");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		ublog.setBlogCreatedAt(dateFormat.format(date));
		ublog.setBlogId(ublog.CreateBlogID());
		ublog.setBlogLike(0);
		ublog.setApprovalStatus('N');
		ublog.setBlogStatus('N');
		ublog.setUseremail((String)session.getAttribute("loggeduser"));
		
		boolean flag = service.saveUserBlog(ublog);
		
		if(!flag){
			log.debug("error in calling => createUserblog() method");
			return new ResponseEntity<Blog>(ublog, HttpStatus.CONFLICT);
		}
		else
		{
			log.debug("Update user blog");
			return new ResponseEntity<Blog>(ublog, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/alluserblog", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Blog>> listAllUserBlog()	{

		log.debug("calling => alluserblog() method");
		List<Blog> lsts = service.getAllBlogs();
		if(lsts.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("total Blogs :" + lsts.size());
		return new ResponseEntity<List<Blog>>(lsts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getblogbyid/{blgid}", method = RequestMethod.GET)
	public ResponseEntity<Blog> getblogbyid(@PathVariable("blgid") String blgid)	{

		log.debug("calling => getblogbyid() method");
		Blog userblog = service.getBlogByID(blgid);
		
		if(userblog==null){
			return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Blog>(userblog, HttpStatus.OK);
	}

	@RequestMapping(value = "/getapproveblog/{blgid}", method = RequestMethod.POST)
	public ResponseEntity<Blog> getapproveblog(@PathVariable("blgid") String blgid)	{

		log.debug("calling => getapproveblog() method");
		boolean flag = service.updateApprove(blgid, 'A');
		if(!flag){
			return new ResponseEntity<Blog>(HttpStatus.BAD_REQUEST);
		}
		Blog userblog = service.getBlogByID(blgid);
		return new ResponseEntity<Blog>(userblog, HttpStatus.OK);
	}	

	@RequestMapping(value = "/getdeleteblog/{blgid}", method = RequestMethod.POST)
	public ResponseEntity<Blog> getdeleteblog(@PathVariable("blgid") String blgid)	{
		log.debug("calling => getapprovegetdeleteblogblog() method" + blgid);
		boolean flag = service.getDelete(blgid);
		if(!flag){
			return new ResponseEntity<Blog>(HttpStatus.BAD_REQUEST);
		}
		Blog userblog = service.getBlogByID(blgid);
		return new ResponseEntity<Blog>(userblog, HttpStatus.OK);
	}	

	@RequestMapping(value = "/getupdatelike/{blgid}", method = RequestMethod.POST)
	public ResponseEntity<Blog> getupdatelike(@PathVariable("blgid") String blgid)	{

		log.debug("calling => Likeblog() method");
		boolean flag = service.getUpdateLike(blgid);
		System.out.println("Found :" + flag);
		if(!flag){
			return new ResponseEntity<Blog>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("Execute query.........");
		Blog userblog = service.getBlogByID(blgid);
		return new ResponseEntity<Blog>(userblog, HttpStatus.OK);
	}	
}
