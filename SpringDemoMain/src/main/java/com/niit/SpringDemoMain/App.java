package com.niit.SpringDemoMain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import config.AppConfig;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     //   System.out.println( "Hello World!" );
        
 AbstractApplicationContext ctx=new   
		 AnnotationConfigApplicationContext(AppConfig.class);
 HelloWorld h= (HelloWorld)ctx.getBean("helloworld");
 System.out.println(h.sayHello());
    
    }
}
