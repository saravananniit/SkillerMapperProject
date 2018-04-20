package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.DAO.EmployeeDAO;
import com.Impl.EmpImpl;

public class EmployeeTest {

	EmpImpl obj; 
	
	@Before
	public void setUp() throws Exception {
		obj=new EmployeeDAO();
	}

	@After
	public void tearDown() throws Exception {
		obj=null;
	}

	@Test
	public void testEmpInsert() {
		
		String x=obj.insertEmp(4,"ss","fac" ,"male","chennai","999999","ss@gmail.com","2000/09/07","2010/03/05");
		System.out.println(x);
		assertEquals("sucess",x);
		
	}
	
	

}
