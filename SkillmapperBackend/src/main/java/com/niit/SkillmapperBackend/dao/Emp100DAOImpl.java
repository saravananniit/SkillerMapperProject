package com.niit.SkillmapperBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillmapperBackend.model.Employee;
@Repository("employeeDAO")
@Transactional
public class Emp100DAOImpl implements Emp100DAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession()
				.createQuery("from Employee")
				.list();
		
		//return null;
	}

	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		//return null;
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empId="+empId)
				.uniqueResult();
	
	
	}

	public Employee findByName(String name) {
		// TODO Auto-generated method stub
	
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where name='"+name+"'")
				.uniqueResult();
	
		//	return null;
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(employee);
	//	sessionFactory.getCurrentSession().evict(employee);
		return true;

		
//		return false;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
	//	sessionFactory.getCurrentSession().evict(employee);
		
		sessionFactory.getCurrentSession().update(employee);
				return true;

		
//		return false;
	}

	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().delete(findById(empId));	
		return true;

		//	return false;
	}

	
	
}
