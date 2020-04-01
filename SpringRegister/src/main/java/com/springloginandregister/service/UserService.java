package com.springloginandregister.service;

import com.springloginandregister.model.Login;
import com.springloginandregister.model.User;

public interface UserService 
{
    void Register(User user);

	User ValidateUser(Login login);
   
}
