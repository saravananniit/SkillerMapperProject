package com.niit.SkillmapperBackend.dao;

import java.util.List;

import com.niit.SkillmapperBackend.model.Employee;

public interface Emp100DAO {
	
	public List<Employee> findAll();
	public Employee findById(int empId);
	public Employee findByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);


}
