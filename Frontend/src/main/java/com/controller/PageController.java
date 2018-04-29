package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value="/AboutUs" , method=RequestMethod.GET)
	public String showAboutUs()
	{
		return "AboutUs";
	}
	@RequestMapping(value="/ContactUs", method=RequestMethod.GET)
	public String showContactUs()
	{
		return "ContactUs";
	}
	@RequestMapping(value="/AdminHome", method=RequestMethod.GET)
	public String showAdminHome()
	{
		return "AdminHome";
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String showLoginPage()
	{
		return "Login";
	}
	@RequestMapping(value="/UserHome", method=RequestMethod.GET)
	public String showUserHomePage()
	{
		return "UserHome";
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showHomePage()
	{
		return "index";
	}
	
	@RequestMapping(value="/Home", method=RequestMethod.GET)
	public String showHome()
	{
		return "index";
	}
	
	@RequestMapping(value="/Samsung", method=RequestMethod.GET)
	public String showSamsung()
	{
		return "Samsung";
	}

}
