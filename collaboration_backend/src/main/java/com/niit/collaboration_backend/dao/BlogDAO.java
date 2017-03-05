package com.niit.collaboration_backend.dao;

import java.util.List;

import com.niit.collaboration_backend.model.Blog;

public interface BlogDAO {
	
	public List<Blog> getAllBlogs();
	
	public boolean saveUserBlog(Blog ubObj);
	
	public boolean updateApprove(String blgid, char flag);
		
	public Blog getBlogByID(String blgid);

	public boolean getUpdateLike(String blgid);
	
	public boolean getDelete(String blgid);
}
