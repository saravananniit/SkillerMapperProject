package com.niit.SkillmapperBackend.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SkillmapperBackend.config.AppContext;
import com.niit.SkillmapperBackend.model.Employee;
import com.niit.SkillmapperBackend.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)

public class EmployeeTest {

	
	@Autowired
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
	/*
		if(employeeService.findEmployeesByName("Ryan")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ryan").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("John")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("Chris")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
		}
		Employee emp1=new Employee();
		emp1.setName("John");
		emp1.setEmail("john@gmail.com");
		Employee emp2=new Employee();
		emp2.setName("Chris");
		emp2.setEmail("chris@gmail.com");
		employeeService.addEmployee(emp1);
		employeeService.addEmployee(emp2);

	*/
	}

	@After
	public void tearDown() throws Exception {
	/*	employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
		employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
		if(employeeService.findEmployeesByName("Ryan")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ryan").getEmpId());
		
		}
		*/

	
	}

/*	
	@Test
	public void testDeleteEmployee() {
		
			assertEquals(true, employeeService.deleteEmployee(1));
				
	}
*/
	
	
	@Test
	public void testAddEmployee() {
		
		Employee emp=new Employee();
		emp.setName("as");
		emp.setEmail("n@gmail.com");
		emp.setEmpid(101);
		assertEquals(true, employeeService.addEmployee(emp));
				
	}

	/*
	
	@Test
	public void testupdateEmployee() {
		
		Employee emp=new Employee();
		emp.setName("Ryas346");
		emp.setEmail("rn6@gmail.com");
		emp.setEmpid(1);
		assertEquals(true, employeeService.updateEmployee(emp));
				
	}
	*/
	

/*
	@Test //(expected=ConstraintViolationException.class)
	public void testAddEmployeeFailure() {
		
		Employee emp=new Employee();
		emp.setName("Johns");
		emp.setEmail("john@gmail.com");
		
		assertEquals(true, employeeService.addEmployee(emp));
				
	}

*/

}
