package com.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import model.User;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(Locale locale, Model model)
	//ModelMap model) {
	{
	model.addAttribute("message", "Hello NIIT Spring MVC Framework!");

	System.out.println("Home Page Requested, locale = " + locale);
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

	String formattedDate = dateFormat.format(date);

	model.addAttribute("serverTime", formattedDate);
	
	return "hello";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}

	
	
}
