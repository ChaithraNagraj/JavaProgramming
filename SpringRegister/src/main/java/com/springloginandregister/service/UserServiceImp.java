package com.springloginandregister.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.soringloginregister.dao.Userdao;
import com.springloginandregister.model.Login;
import com.springloginandregister.model.User;
/** Here we are validating the user to further Login and register move
**/
public class UserServiceImp  implements UserService
{
@Autowired
Userdao userDao;

	public void Register(User user)
	{
		userDao.Register(user);	
	}

	public User ValidateUser(Login login)
	{
		
		return userDao.ValidateUser(login);
	}



	
}
