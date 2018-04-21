package com.niit.skillmapper.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.*;
import com.Impl.*;
import com.Model.*;




/**
 * Servlet implementation class HR
 */
@WebServlet("/skills.do")
public class HR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	private static final long serialVersionUID = 1L;
    
	private List<Skill>  skillLists;
	
	private SkillDAO dao;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		dao=new SkillDAO();
		PrintWriter out=response.getWriter();	
		int i=1;
		try
		{
			List<Skill>	skillLists=dao.getSkillsByStatus();
	
		
		
		
		
		HttpSession session=request.getSession();
		List<Integer>  list=new ArrayList<>();
		
		session.setAttribute("empid",list);
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='update.do' method=post>");
		out.println("<h3 align='center'>Employee Skills List....</h3>");
		
		out.println("<table border=1>");
		out.println("<tr><th>Employee Code</th><th>SkillSet</th><th>Certification</th><th>Trained Hours</th><th>Students Trained</th><th>Rating</th><th>Student Placed</th><th>Total Experience </th><th>Language Known </th><th>Approved(A/R)</th><th>Remarks</th></tr>");
		if(!skillLists.isEmpty())
		{
			
			for(Skill  skill :  skillLists)
			{
				out.println("<tr><td>"+skill.getEmp_id()+"</td><td>"+skill.getSkills()+"</td><td>"+skill.getCertification()+"</td><td>"+skill.getTeaching_hours()+"</td><td>"+skill.getTrained_no_of_stdnts()+"</td><td>"+skill.getSkill_rating()+"</td><td>"+skill.getTrained_no_of_stdnts()+"</td><td>"+skill.getYrs_of_expr()+"</td><td>"+skill.getLang_known()+"</td><td><select name='status'><option value='UNKNOWN'>Select an Option...</option><option value=Accepted>Accepted</option><option value=Rejected>Rejected</option></select><input type=hidden name=empcode value="+skill.getEmp_id()+"></td><td><input type=text name=rmks></td></tr>");
				
				//list.add(skill.getEmpcode());
				//System.out.println(i);
				//i++;
			}
		}
		
		
		out.println("<table>");
		out.println("<center><input type=submit value=update></center>");
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		}catch(Exception e)
		{
			out.println("No rows matched");
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
