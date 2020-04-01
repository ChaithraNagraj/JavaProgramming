package com.springloginandregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springloginandregister.model.User;
import com.springloginandregister.service.UserService;



@Controller
public class RegisterController 
{
	@Autowired
	UserService userService;
@RequestMapping("/")
public ModelAndView home()
{
	ModelAndView mv=new ModelAndView("index");
	return mv;
}
@RequestMapping(value="Register")
public String Register()
{
	 return "Register";
}
@RequestMapping(value = "Login")
public ModelAndView Login()
{
	ModelAndView mv=new ModelAndView("Login");
	return mv;
}
@RequestMapping(value="registerProcess",method=RequestMethod.POST)
public ModelAndView RegisterProcess(HttpServletRequest request,HttpServletResponse response,User user)
{
	userService.Register(user);
	return new ModelAndView("index","Name",user.getFstname());
}

@RequestMapping(value="LoginProcess",method=RequestMethod.POST)
public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse response,com.springloginandregister.model.Login login)
{
	ModelAndView mav;
	System.out.println(login.getuname());
	System.out.println(login.getpswd());
	
	User user=userService.ValidateUser(login);
	
	if(null!=user)
	{
		mav=new ModelAndView("index");
		mav.addObject("Firstname", user.getUsrname());
	}
	else
	{
		mav=new ModelAndView("Login");
		mav.addObject("message","User name or password is wrong !");
	}
	return mav;

}



}

