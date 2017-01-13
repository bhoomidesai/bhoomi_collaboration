package com.niit.collaboration_backend.dao;

import java.util.List;

import com.niit.collaboration_backend.model.UserType;

public interface UserTypeDAO {

	public List<UserType> getAllUserTypes();
	
	public boolean userTypeUpdate(UserType userType);
		
	public UserType getUserTypeByID(int usertypeid);
	
	public boolean checkUserType(String utype);
	
	public boolean deleteusertype(int usertypeid);
}
