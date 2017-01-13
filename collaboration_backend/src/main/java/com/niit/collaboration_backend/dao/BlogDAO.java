package com.niit.collaboration_backend.dao;

import java.util.List;

import com.niit.collaboration_backend.model.Blog;

public interface BlogDAO {
	
	public List<Blog> getAllBlogs();
	
	public boolean saveUserBlog(Blog ubObj);
	
	public boolean updateApprove(int blgid, char flag);
		
	public Blog getBlogByID(int blgid);

	public boolean getUpdateLike(int blgid);
	
	public boolean getDelete(int blgid);
}
