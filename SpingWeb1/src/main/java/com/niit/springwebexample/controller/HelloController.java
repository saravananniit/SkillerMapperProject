package com.niit.springwebexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.niit.springwebexample.domain.*;;
@Controller
public class HelloController {

	

	@Autowired
	private HelloWorld helloWorld;
	
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("hello", helloWorld.sayHello());
		 SecurityContext context = SecurityContextHolder.getContext();
	      
	      model.addAttribute("message", "You are logged in as " 
	                     + context.getAuthentication().getName());
		
		return "index";
	}

	
}

