package com.springwebmvc.repositry;

import com.springwebmvc.model.User;

public interface UserDao 
{

	public int registerUser(User user);
	public String loginUser(User user);
}
