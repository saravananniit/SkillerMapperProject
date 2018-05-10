package com.niit.EmployeeRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SkillmapperBackend.model.Employee;
import com.niit.SkillmapperBackend.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> listAllEmployees() {
		
		
		  List<Employee> employee=employeeService.findAllEmployees();//
		//, HttpStatus.CREATED);
		  return employee;
	}
	
	
	/*
	@GetMapping
	public ResponseEntity<List<Employee>>  listAllEmployees() {
		
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployees(), HttpStatus.CREATED);
		
		//return new ResponseEntity <Emp List<Employee> employee=employeeService.findAllEmployees();//
		//, HttpStatus.CREATED);
		  //return employee;
	}
	*/
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
		
		if(employeeService.findEmployeesById(empId)!=null) {
			return new ResponseEntity<Employee>(employeeService.findEmployeesById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") int empId) {
		
		if(employeeService.findEmployeesById(empId)!=null) {
			employeeService.deleteEmployee(empId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		
		if(employeeService.findEmployeesByName(employee.getName())!=null) {
			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			employeeService.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
		
		if(employeeService.findEmployeesById(employee.getEmpId())!=null) {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
