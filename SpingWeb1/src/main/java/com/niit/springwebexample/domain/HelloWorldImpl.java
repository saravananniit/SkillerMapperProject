package com.niit.springwebexample.domain;
	

	import org.springframework.stereotype.Component;
	

	@Component("helloWorld")
	public class HelloWorldImpl implements HelloWorld{
	

		public String sayHello() {
			
			return "HelloWorld";
		}
	

	}
