package com.niit.skillmapper.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.niit.skillmapper.validators.Validator;
import com.Impl.*;
import com.DAO.*;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
public	static List<String> errors=new LinkedList<>();       
 EmpImpl e;
 UserImpl u;

/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
   e=new EmployeeDAO();
   u=new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
try
{
		PrintWriter out=response.getWriter();
		int		emp_code=Integer.parseInt(request.getParameter("code").trim());
	
		
		
		String name =request.getParameter("name").trim();
		
		String designation=request.getParameter("desgn").trim();
	
			String gender=request.getParameter("gender").trim();
		String city=request.getParameter("city").trim();
		String contact=request.getParameter("contact").trim();
		String email=request.getParameter("email").trim();
		String dateofjoining=request.getParameter("dateofjoining").trim();
		String dateofbirth=request.getParameter("dateofbirth").trim();
		String password=request.getParameter("password").trim();
		String confirmPassword=request.getParameter("confirmpassword").trim();
		String role=request.getParameter("role").trim();
		 HttpSession session=request.getSession();  
		         session.setAttribute("emp_code",emp_code);  

		
String x=e.insertEmp(emp_code, name,designation, gender, city, contact, email, dateofjoining,dateofbirth);
	//	String y=e.insertEmp(emp_code,name,designation,gender,city,contact,email,dateofjoining,dateofbirth);
        
		out.println(x);
		if(x.equals("sucess"))
		{
			
			String y=u.insertUser(emp_code,password,role,"N","Newly Created");
			
		request.getRequestDispatcher("SkillController").forward(request, response);
		}
//if(x.equals("fail"))
//{
//	request.getRequestDispatcher("/WEB-INF/Views/JSP/Rerror.jsp").forward(request, response);
//}

}catch(Exception e)

{
	//response.getWriter().println("DATA error found");
//	e.printStackTrace();
	request.getRequestDispatcher("/WEB-INF/Views/JSP/index.jsp").forward(request, response);
	
}
		
	//	int emp_code=0;
//		try
	//	{
//		}
	//	catch(NumberFormatException ne)
		//{
			
			//errors.add("Employee Id should be a possitive Integer.....");
	//	}
		
		
	//	if(Validator.rejectIfEmpty(name))
		//{
			//errors.add("Name Field cannot be Left Blank.....");
		//}
		
		
//		if(Validator.rejectIfEmpty(designation))
	//	{	errors.add("Designation Field cannot be Left Blank.....");}
	
//		if(Validator.rejectIfEmpty(gender))
	//	{	errors.add("Gender Field cannot be Left Blank.....");}
	
		//if(Validator.rejectIfEmpty(city))
	//	{	errors.add("City Field cannot be Left Blank.....");}
	
	
//		if(Validator.rejectIfEmpty(contact))
	//	{	
		//	errors.add("Phone Field cannot be Left Blank.....");}
		
		
		/*catch(NumberFormatException ne)
		{
			errors.add("Phone number should be positive integer");
			
		}*/
//		try
//		{
	//	if(Validator.rejectValue(contact))
//		{	errors.add("Phone no should be of 10 Digits.....");}
	//	}catch(NumberFormatException e)
//		{
	//		errors.add("Phone number should be positive integer");
//		}

	//	if(Validator.rejectIfEmpty(email))
//		{	errors.add("Email Field cannot be Left Blank.....");}
		
	//	if(Validator.rejectEmailValue(email))
//		{	errors.add("Email Id is not Valid.....");}
		
	//	if(Validator.rejectIfEmpty(dateofjoining))
//		{	errors.add("Date Of Joining Field cannot be Left Blank.....");}
		
	//	if(Validator.isValidDate(dateofjoining))
//		{	errors.add("Date Of Joining  cannot be Greater than today's Date.....");}
		
//		if(Validator.rejectIfEmpty(dateofbirth))
//		{	errors.add("Date Of Birth Field cannot be Left Blank.....");}
		
//		if(Validator.isValidDate(dateofbirth))
	//	{	errors.add("Date Of Birth  cannot be Greater than today's Date.....");}
		
	//	if(Validator.rejectIfEmpty(password))
	//	{	errors.add("Password Field cannot be Left Blank.....");}
		
	//	if(Validator.rejectIfEmpty(confirmPassword))
//		{	errors.add("Confirmation Password Field cannot be Left Blank.....");}

	//	if(Validator.rejectIfEmpty(role))
	//	{	errors.add("Role Field are not same.....");}

		
//		if(!errors.isEmpty())
	//	{
		//	request.setAttribute("errors",errors);
			
			
		//	request.getRequestDispatcher("/WEB-INF/Views/JSP/index.jsp").forward(request, response);
	//	}


		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
