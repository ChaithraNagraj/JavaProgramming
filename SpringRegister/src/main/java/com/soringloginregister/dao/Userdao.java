package com.soringloginregister.dao;

import com.springloginandregister.model.Login;
import com.springloginandregister.model.User;

public interface Userdao 
{
public void Register(User user);

public User ValidateUser(Login login);

}
