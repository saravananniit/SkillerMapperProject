package com.niit.cruddemo.controller;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	

	import com.niit.SkillmapperBackend.service.*;
	import com.niit.SkillmapperBackend.model.*;
	//import com.niit.cruddemo.service.EmployeeService;
	
	
	@Controller
	public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String listEmployees(Model model) {
	model.addAttribute("employee",new Employee());
	model.addAttribute("employees",employeeService.findAllEmployees());
	
	return "Employee";
	
	}
	
	@PostMapping("/employee/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
	
	if(employee.getEmpId()==0) {
	employeeService.addEmployee(employee);
	}
	else {
	employeeService.updateEmployee(employee);
	}
	
	return "redirect:/";
	}
	
	@GetMapping("/remove/{id}")
	public String removeEmployee(@PathVariable("id") int id){
	
	System.out.println("inside remove method");
	employeeService.deleteEmployee(id);
	return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model){
	model.addAttribute("employee", employeeService.findEmployeesById(id));
	model.addAttribute("employees",employeeService.findAllEmployees());
	return "Employee";
	}
	
	}
