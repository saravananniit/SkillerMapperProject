package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.DBConnection.connect;
import com.Impl.*;
import com.Model.Employee;
import com.Model.Join;
import java.util.*;
import java.sql.*;
public class SearchDAO  implements SearchImpl{
	
	connect c=null;
	Connection db=null;
	Statement stmt=null;
	
	public SearchDAO()
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
	
	public List<Join>Searching(String s)
	{
		
	
		List<Join> j=new LinkedList<Join>();
		
		try{  
			String q="SELECT A.*, B.* from Employee A, Skills B where  A.EMP_ID = B.EMP_ID and skills like '%"+s+"%' ORDER BY A.EMP_ID";
			stmt=db.createStatement();
		//	stmt.setString(1,s);
		
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next())
			{
			Join e1=new Join();
			e1.setEmp_id(rs.getInt(1));
			e1.setEmp_name(rs.getString(2));
			e1.setEmp_designation(rs.getString(3));
			e1.setGender(rs.getString(4));
			e1.setEmp_city(rs.getString(5));
			e1.setEmp_contact_no(rs.getLong(6));
			e1.setEmp_email_id(rs.getString(7));
			e1.setEmp_jointing_date(rs.getDate(8));
			e1.setEmp_date_of_birth(rs.getDate(9));
			e1.setSkills(rs.getString(12));
			e1.setCertification(rs.getString(13));
			e1.setTeaching_hours(rs.getInt(14));
			e1.setTrained_no_of_stdnts(rs.getInt(15));
			e1.setSkill_rating(rs.getInt(16));
			e1.setNo_of_stdns(rs.getInt(17));
			e1.setYrs_of_expr(rs.getInt(18));
			e1.setLang_known(rs.getString(19));
			
			j.add(e1);
				
				
			}
			
		}catch(Exception e)

		{
		e.printStackTrace();	
		}
		
		return j;
		
	}
}
