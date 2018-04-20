package com.DAO;

import java.sql.Connection;
import java.sql.*;
import com.DBConnection.connect;
import com.Impl.*;
import com.Model.User;
import com.Model.*;
import java.util.*;

public class UserDAO implements UserImpl {

	connect c=null;
	Connection db=null;

PreparedStatement stmt=null;
Statement st=null;

		public UserDAO()
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
	public String insertUser(int emp_id, String password, String role, String status, String remarks) {
		// TODO Auto-generated method stub

		String x="fail";
		try{  
			stmt=db.prepareStatement("insert into USERS values(?,?,?,?,?)");  
			stmt.setInt(1,emp_id);//1 specifies the first parameter in the query  
			stmt.setString(2,password);
			stmt.setString(3,role);
			stmt.setString(4,status);
			stmt.setString(5, remarks);
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			x="sucess";
			db.close();  
			}catch(Exception e){ System.out.println(e);}  
			  
		return x;
			}  

		

	@Override
	public List<User> displayUser() {
		List<User> u=new LinkedList<User>();
		ResultSet rs=null;
		try
		{
		st=db.createStatement();
		String sql = "SELECT * FROM USERS";
	      rs = st.executeQuery(sql);
	      
	      while(rs.next()){
	      
	         int emp_id  = rs.getInt("emp_id");
	         String role = rs.getString("role");
	         String password = rs.getString("password");
             String status=rs.getString("status");
             String remarks=rs.getString("remarks");
	         //Display values
	         System.out.print("EMP ID: " + emp_id);
	         System.out.print("PASSWORD : " + password);
	         System.out.println("ROLE: " + role);
	         System.out.println("status"+ status);
	         System.out.println("remarks"+ remarks);
	         User ob=new User();
	         ob.setEmp_id(emp_id);
	         ob.setPassword(password);
	         ob.setStatus(status);
	         ob.setRemarks(remarks);
	         ob.setRole(role);
	         u.add(ob);
	      }
	      
	      rs.close();	
		}catch(Exception e)
		{
		
			e.printStackTrace();
			
		}	        
		
		return u;
	}

		
	
		
	

	@Override
	public String deleteUser(int u) {
		// TODO Auto-generated method stub
	//	return null;
		String x="fail";
		try{  
			stmt=db.prepareStatement("delete from USERS where emp_id=?");  
			stmt.setInt(1,u);//1 specifies the first parameter in the query  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			x="sucess";
			db.close();  
			}catch(Exception e){ System.out.println(e);}  
			  
		return x;
			}  

	
	}


