package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.DAO.SkillDAO;
import com.Impl.SkillImpl;

public class SkillTest {
SkillImpl s;
	@Before
	public void setUp() throws Exception {
		s=new SkillDAO();
	}

	@After
	public void tearDown() throws Exception {
		s=null;
	}

	@Test
	public void test() {
	//	fail("Not yet implemented");
	
		String x=s.insertSkill(102,"java","scjp",100,1400,8,150,11,"English");
		System.out.println(x);
		assertEquals("sucess",x);
	}

}
