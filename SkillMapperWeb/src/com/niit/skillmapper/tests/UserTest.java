package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.Impl.*;
import com.DAO.*;
public class UserTest {
UserImpl u;
	@Before
	public void setUp() throws Exception {
		u=new UserDAO();
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}

	@Test
	public void test() {
		
		String x=u.insertUser(007,"password","faculty","N","forwarded");
			System.out.println(x);
			assertEquals("sucess",x);
    	//fail("Not yet implemented");
	}

}
