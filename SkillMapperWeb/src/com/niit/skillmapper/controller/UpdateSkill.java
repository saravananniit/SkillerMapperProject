package com.niit.skillmapper.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class UpdateSkill
 */
import com.DAO.*;
import com.Impl.*;
import com.DAO.*;
@WebServlet("/update.do")
public class UpdateSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	SkillDAO dao;
	
	public UpdateSkill() {
        super();
        // TODO Auto-generated constructor stub
        
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String empids[]=request.getParameterValues("empcode");
		String values[]=request.getParameterValues("status");
		String remarks[]=request.getParameterValues("rmks");
		dao=new SkillDAO();
		int rows=0;
		for(int i=0;i<values.length;i++)
			
		{
			if(values[i].equals("UNKNOWN"))
			{
				continue;
			}
			
			rows=dao.updateSkills(Integer.parseInt(empids[i]), values[i], remarks[i]);
			
			
		}
		
		
		
		if(rows > 0)
			request.getRequestDispatcher("/WEB-INF/Views/JSP/index.jsp").forward(request,response);
		else
			response.getWriter().println("Failed to update the DB....");
		
		/*for(String   id :  values)
			
		

		for(String id :  remarks)
			response.getWriter().println(id);
*//*for(int i=0;i < values.length;i++)
{
	String str=values[i];
	
	String remark=remarks[i];
	
	
	
	
	
	
}
*/		
		
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
