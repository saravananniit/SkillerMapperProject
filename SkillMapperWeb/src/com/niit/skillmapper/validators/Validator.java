package com.niit.skillmapper.validators;

import java.util.Date;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {

	public static boolean rejectIfEmpty(String data)
	{
				
		return data != null && data.length() == 0;
	}
	
	

	public static boolean rejectValue(String data) throws NumberFormatException
	{
		boolean value=false;
		try
		{
			int intValue=Integer.parseInt(data);
			
			if(!(intValue == 10))
				value=true;
				
		}
		catch(NumberFormatException  exe)
		{
			throw new NumberFormatException();
		}
		return value;
	}
	
	
	
	public static boolean rejectEmailValue(String data) //throws NumberFormatException
	{
		
		boolean value=false;
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(data).matches())) {
        
    	  
    	   value=true;

      }    	  
    	  
    	  return value;
	}
	
	
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean isValidDate(String input) {
		
		
		boolean valid=false;
		     
	     try {
	          Date d=format.parse(input);
	          
	          Date currentDate=new Date(System.currentTimeMillis());
	          
	                   if(d.after(currentDate))
	          valid=true;
	     }
	     catch(ParseException e){
	          e.printStackTrace();
	     }
	     
	     
	     return valid;
	}

	
	public static boolean rejectIdValue(int value) //throws NumberFormatException
	{
		boolean isIntValue=false;
		try
		{
			
			if(!(value == 5))
				isIntValue=true;
				
		}
		catch(NumberFormatException  exe)
		{
			throw new NumberFormatException("Employee Id is not in the format format");
		}
		return isIntValue;
	}
	
	
	public static boolean isPasswordDifferent(String password,String confirmPassword) 
	{
		boolean valid=false;
		if(!(password.equals(confirmPassword)))
		valid=true;
		
		
		
		return valid;
	}

}
