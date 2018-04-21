package com.DAO;

import java.sql.Connection;
import com.Model.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import com.DBConnection.connect;
import com.Impl.*;
import com.Model.Skill;
public class SkillDAO implements SkillImpl {

	connect c=null;
	Connection db=null;
	PreparedStatement stmt=null;
    Statement st=null;

		public SkillDAO()
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
	public String insertSkill(int emp_id, String skills, String certification, int teaching_hours,
			int trained_no_of_stdnts, int skill_rating, int no_of_stdns, int yrs_of_expr, String lang_known) {
		// TODO Auto-generated method stub
		String x="fail";
		try{  
			stmt=db.prepareStatement("insert into SKILLS (emp_id,skills,certification,teaching_hours,trained_no_of_stdnts,skill_rating,no_of_stdnts_plcd,yrs_of_expr,lang_known)values(?,?,?,?,?,?,?,?,?)");  
			stmt.setInt(1,emp_id);  
			stmt.setString(2,skills);
			stmt.setString(3,certification);
			stmt.setInt(4,teaching_hours);  
			stmt.setInt(5,trained_no_of_stdnts);
			stmt.setInt(6,skill_rating);
			stmt.setInt(7,no_of_stdns);
			stmt.setInt(8,yrs_of_expr);
			stmt.setString(9,lang_known);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			x="sucess";
			db.close();  
			}catch(Exception e){ System.out.println(e);}  
			  
		return x;
			}  


		

	@Override
	public List<Skill> displaySkill() {
		ResultSet rs=null;
		List<Skill> s=new LinkedList<Skill>();
		try
		{
		st=db.createStatement();
		String sql = "SELECT * FROM SKILLS";
	      rs = st.executeQuery(sql);
	      
	      while(rs.next()){
	      
	         
	      int emp_id=rs.getInt("emp_id");  
	      String skills=rs.getString("skills");
	      String certification=rs.getString("certification");
	      int teaching_hours=rs.getInt("teaching_hours");
	      int trained_no_of_stdnts=rs.getInt("trained_no_of_stdnts");
	      int skill_rating =rs.getInt("skill_rating");
	      int no_of_stdns=rs.getInt("no_of_stdnts_plcd");
	      int yrs_of_expr=rs.getInt("yrs_of_expr");
	      String lang_known=rs.getString("lang_known");
	      System.out.println(emp_id);
	      System.out.println(skills);
	      System.out.println(certification);
	      System.out.println(teaching_hours);
	      System.out.println(trained_no_of_stdnts);
	      System.out.println(skill_rating);
	      System.out.println(no_of_stdns);
	      System.out.println(yrs_of_expr);
	      System.out.println(lang_known);
	      Skill ob=new Skill();
	      ob.setEmp_id(emp_id);
	      ob.setSkills(skills);
	      ob.setCertification(certification);
	      ob.setTeaching_hours(teaching_hours);
	      ob.setTrained_no_of_stdnts(trained_no_of_stdnts);
	      ob.setSkill_rating(skill_rating);
	      ob.setNo_of_stdns(no_of_stdns);
	      ob.setYrs_of_expr(yrs_of_expr);
	      ob.setLang_known(lang_known);
	      s.add(ob);
	      
	      
	      
	      }
	      
	      
	      rs.close();	
		}catch(Exception e)
		{
		
			e.printStackTrace();
			
		}	        

		return s;
	}

	
	
	
	
	
	
	@Override
	public String deleteSkill(int s) {
		String x="fail";
		try{  
			stmt=db.prepareStatement("delete from SKILLS where emp_id=?");  
			stmt.setInt(1,s);//1 specifies the first parameter in the query  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			x="sucess";
			db.close();  
			}catch(Exception e){ System.out.println(e);}  
			  
		return x;
			}

	@Override
	public int updateSkills(int empid, String status, String remarks) {
		// TODO Auto-generated method stub
	//	return 0;
		String dataToUpdate="R";
		int rows=0;
		if(status.equals("Accepted"))
			dataToUpdate="A";
		
		try(PreparedStatement stmt=db.prepareStatement("update users set status=?,remarks=? where Emp_id=?");
				
				
					
			   )
			{
				
			
			stmt.setString(1,dataToUpdate);
			stmt.setString(2, remarks);
			stmt.setInt(3, empid);
			
				rows=stmt.executeUpdate();
				
			}               
			catch(SQLException exe)
			{
				exe.printStackTrace();
			}
			
		return rows;
		
		
		

	
	}

	@Override
	public List<Skill> getSkillsByStatus() {
		// TODO Auto-generated method stub
	//	return null;
		ResultSet rs=null;
//		List<Skill> s=new LinkedList<Skill>();
		List<Skill> skillList=new LinkedList<Skill>();

		try
		{
		st=db.createStatement();
//		String sql = "SELECT * FROM SKILLS";
		String sql="select a.Emp_Id,Skills,Certification,teaching_hours,trained_no_of_stdnts,skill_rating,no_of_stdnts_plcd,yrs_of_expr,lang_known from Skills a join users b  on a.emp_id = b.emp_id where b.status='N'";
		rs=st.executeQuery(sql);
	//	rs
//		int i= st.executeUpdate(sql);
	//	System.out.println(i+"no of rows affected");
			while(rs.next())
			{
				System.out.println(rs);	
				Skill skills=new Skill();
				skills.setEmp_id(rs.getInt(1));
				skills.setSkills(rs.getString(2));
				skills.setCertification(rs.getString(3));
				skills.setTeaching_hours(rs.getInt(4));
				skills.setTrained_no_of_stdnts(rs.getInt(5));
				skills.setSkill_rating(rs.getInt(6));
				skills.setTrained_no_of_stdnts(rs.getInt(7));
				skills.setYrs_of_expr(rs.getInt(8));
				skills.setLang_known(rs.getString(9));
				//rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getString(9));
				skillList.add(skills);
			}
			
			
			rs.close(); db.close();
		}               
		catch(SQLException exe)
		{
		exe.printStackTrace();	
		}
		
		System.out.println(skillList.size()+"...............");
		return skillList;

	
	}  
		
		// TODO Auto-generated method stub
		//return null;
	}

	

