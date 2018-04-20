package com.DAO;

import com.Impl.*;
import com.Model.Employee;
import com.Model.User;

import com.DBConnection.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
public class EmployeeDAO implements EmpImpl {
	
	connect c=null;
Connection db=null;
PreparedStatement stmt=null;
Statement st=null;

	public EmployeeDAO()
	{
		try
		{
		 c=new connect();
         db=c.con();
		}catch(Exception e)
		{
		System.out.println(e);	
		}
		
	}


	@Override
	public String insertEmp(int emp_id, String emp_name, String emp_designation, String gender, String emp_city,
			String emp_contact_no, String emp_email_id, String emp_jointing_date, String emp_date_of_birth) {
		// TODO Auto-generated method stub
		String x="fail";
		try{  
			stmt=db.prepareStatement("insert into EMPLOYEE values(?,?,?,?,?,?,?,?,?)");  
			stmt.setInt(1,emp_id);//1 specifies the first parameter in the query  
			stmt.setString(2,emp_name);  
			stmt.setString(3,emp_designation);
			stmt.setString(4,gender);
			stmt.setString(5,emp_city);  
			stmt.setString(6,emp_contact_no);
			stmt.setString(7,emp_email_id);
			SimpleDateFormat dtformat=new SimpleDateFormat("dd/mm/yyyy"); 
			java.sql.Date dt = new java.sql.Date(dtformat.parse(emp_jointing_date).getTime()); 
			stmt.setDate(8,dt); 
			java.sql.Date dt1 = new java.sql.Date(dtformat.parse(emp_date_of_birth).getTime()); 
			stmt.setDate(9,dt1); 
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			x="sucess";
			db.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
		return x;

		

	}


	@Override
	public List<Employee> displayEmp() {
		List<Employee> e=new LinkedList<Employee>();		
		ResultSet rs=null;
		try
		{
		st=db.createStatement();
		String sql = "SELECT * FROM EMPLOYEE";
	      rs = st.executeQuery(sql);
	      
	      while(rs.next()){
	      
	         int emp_id  = rs.getInt("emp_id");
	         String emp_name=rs.getString("emp_name");  
	      String emp_designation=rs.getString("emp_designation");
	      String gender=rs.getString("gender");
	      String emp_city=rs.getString("emp_city");
	      int emp_contact_no=rs.getInt("emp_contact_no");
	      String emp_email_id =rs.getString("emp_email_id");
	      Date emp_joining_date=rs.getDate("emp_joining_date");
	      Date emp_date_of_birth=rs.getDate("emp_date_of_birth");
	      System.out.println(emp_id);
	      System.out.println(emp_name);
	      System.out.println(emp_designation);
	      System.out.println(gender);
	      System.out.println(emp_city);
	      System.out.println(emp_contact_no);
	      System.out.println(emp_email_id);
	      System.out.println(emp_joining_date);
	      System.out.println(emp_date_of_birth);
	     

Employee emp=new Employee();
emp.setEmp_id(emp_id);
emp.setEmp_name(emp_name);
emp.setEmp_designation(emp_designation);
emp.setGender(gender);
emp.setEmp_city(emp_city);
emp.setEmp_contact_no(emp_contact_no);
emp.setEmp_email_id(emp_email_id);
emp.setEmp_jointing_date(emp_joining_date);
emp.setEmp_date_of_birth(emp_date_of_birth);

	      e.add(emp);
	      
	      }
	      
	      rs.close();	
		}catch(Exception e1)
		{
		
			e1.printStackTrace();
			
		}	        

return e;
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public String deleteEmp(int e) {
		// TODO Auto-generated method stub
		//return null;
		String x="fail";
		try{  
			stmt=db.prepareStatement("delete from Employee where emp_id=?");  
			stmt.setInt(1,e);//1 specifies the first parameter in the query  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			x="sucess";
			db.close();  
			}catch(Exception p){ System.out.println(p);}  
			  
		return x;
			}  
	
	}
