package com.springwebmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springwebmvc.model.User;
import com.springwebmvc.repositry.UserDao;
@Controller
public class UserRegistrationController 
{

	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userId")String userId,@RequestParam("password")String password)
	{
		ModelAndView mv =new ModelAndView();
		User user =new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		int counter=userDao.registerUser(user);
		
		if(counter>0)
		{
			mv.addObject("msg","succesfull");
			mv.setViewName("login");
		}
		else
		{
			mv.addObject("msg","error");
			mv.setViewName("registration");
		}
		
	
		return mv;
		
	}


}
