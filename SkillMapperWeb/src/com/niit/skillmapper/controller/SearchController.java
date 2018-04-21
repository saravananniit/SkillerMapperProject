package com.niit.skillmapper.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Impl.*;
import com.DAO.*;
import java.util.*;
import com.Model.*;
/**
 * Servlet implementation class SearchController
 */
@WebServlet("/apple.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	PrintWriter out=response.getWriter();
	out.println("welcome to searching");
	SearchDAO s=new SearchDAO();
	String param=request.getParameter("code");
	out.println(param);
List<Join> ls=	s.Searching(param);
out.println("<table border=1>");
out.println("<tr><th>Employee Id</th><th>Employee Name</th></tr>");
if(!ls.isEmpty())
{
	for(Join q: ls)
{
		
		out.println("<tr><td>"+q.getEmp_id()+"</td><td>"+q.getEmp_name()+"</td></tr>");

}
	
	out.println("</table>");

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
