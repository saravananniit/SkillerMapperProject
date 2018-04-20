package com.niit.skillmapper.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  


import com.Impl.SkillImpl;
import com.DAO.*;
/**
 * Servlet implementation class SkillUpdateController
 */
@WebServlet("/update")
public class SkillUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 SkillImpl s;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillUpdateController() {
        super();
        s=new SkillDAO(); 
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		HttpSession session=request.getSession(false);  
        int emp_code=(int)session.getAttribute("emp_code");  

		//int i=Integer.parseInt(emp_code);
		PrintWriter out=response.getWriter();
	//	int		emp_code=Integer.parseInt(request.getParameter("code").trim());
			
		String skset =request.getParameter("skSet").trim();
		
		String cert=request.getParameter("cert").trim();
	
			int texp=Integer.parseInt(request.getParameter("Texp").trim());
		int nstdt=Integer.parseInt(request.getParameter("NStdT").trim());
		int fr=Integer.parseInt(request.getParameter("fr").trim());
		int nsplc=Integer.parseInt(request.getParameter("Nsplc").trim());
		int yexp=Integer.parseInt(request.getParameter("yexp").trim());
		String lknow=request.getParameter("lknow").trim();
		
		
try
{
String x=s.insertSkill(emp_code,skset,cert,texp,nstdt,fr,nsplc,yexp,lknow);

		out.println(x);
		if(x.equals("sucess"))
		{
			
	//		String y=u.insertUser(emp_code,password,role,"N","Newly Created");
			
		request.getRequestDispatcher("/WEB-INF/Views/JSP/Rsucess.jsp").forward(request, response);
		}
		
}catch(Exception e)

{
	//response.getWriter().println("DATA error found");
	e.printStackTrace();
	request.getRequestDispatcher("/WEB-INF/Views/JSP/Rerror.jsp").forward(request, response);
	
}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
