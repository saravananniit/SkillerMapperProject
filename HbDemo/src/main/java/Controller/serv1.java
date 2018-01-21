package Controller;

import java.io.IOException;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Employee;

/**
 * Servlet implementation class serv1
 */
public class serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try
		{
		String name=request.getParameter("t1");
		String password=request.getParameter("t2");
		if(!(name.equals("")))
				{
			
			Configuration config=new Configuration();
			config.configure("Hibernate.cfg.xml");
			SessionFactory sf=config.buildSessionFactory();
			Session sess=sf.openSession();
			
			Transaction tran=sess.beginTransaction();
			Employee emp=new Employee();
			emp.setId(Integer.parseInt(name));
			emp.setName(password);
						sess.save(emp);
			tran.commit();
					
                 // response.getWriter().append(name);

                 // response.getWriter().append(password);

                  response.getWriter().append("Served at: ").append(request.getContextPath());
            response.getWriter().append("done");
            
            Query q=sess.createQuery("from Employee");
				List<Employee>l=(List<Employee>)q.getResultList();
				
				for(Employee empl:l)
				{
					response.getWriter().append(empl.getName());
					
				}
            
				
				}
		else
		{
RequestDispatcher req= request.getRequestDispatcher("index.jsp");
		
				req.forward(request,response);
		
	}
				}catch(Exception e)
				{
					e.printStackTrace();
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
