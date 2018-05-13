package com.niit.SkillmapperBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.SkillmapperBackend.dao.Emp100DAO;
import com.niit.SkillmapperBackend.model.Employee;


@Service
@Repository("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private Emp100DAO employeeDAO;
	public List<Employee> findAllEmployees() {
		
		return employeeDAO.findAll();
	}

	public Employee findEmployeesById(int empId) {
		
		return employeeDAO.findById(empId);
	}

	public boolean addEmployee(Employee employee) {
		
		if(employeeDAO.findById(employee.getEmpid())!=null) {
			return false;
		}
		else {
			employeeDAO.addEmployee(employee);
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
//		int employee_id=employee.getEmpId();
		if(employeeDAO.findById(employee.getEmpid())!=null) {	
		
			employeeDAO.updateEmployee(employee);
		
	System.out.println("inside udpate");
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deleteEmployee(int empId) {
		if(employeeDAO.findById(empId)!=null) {	
			employeeDAO.deleteEmployee(empId);
			return true;
		}
		else {
			return false;
		}
	}

	public Employee findEmployeesByName(String name) {
		
		return employeeDAO.findByName(name);
	}

	
}
