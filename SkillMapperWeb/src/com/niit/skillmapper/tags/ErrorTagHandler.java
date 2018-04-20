package com.niit.skillmapper.tags;
import java.util.Calendar;  
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter;  
import javax.servlet.jsp.tagext.TagSupport;

import com.niit.skillmapper.controller.RegisterController;

import java.util.*;
public class ErrorTagHandler extends TagSupport{

	public int doStartTag() throws JspException {  
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try{  
		    	
		    	
		     out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter  

		     List<String> errors=(List) RegisterController.errors;



		     if(errors != null)
		     {
		     if(!errors.isEmpty())
		     {
		    	   out.print("ERROR :");
		     	for(String error : errors)
		     	{
		     	out.print(error);
		     		
		     	}
		     }
		     errors.clear();	
		     }	
		    
		    }catch(Exception e){System.out.println(e);}  
		    return SKIP_BODY;//will not evaluate the body content of the tag  
		}  

}
