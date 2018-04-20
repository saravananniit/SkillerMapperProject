package com.Impl;
import java.util.Date;
import java.util.*;

import com.Model.*;
public interface EmpImpl {
	
	public String insertEmp(		
			int emp_id,
			String emp_name,
			String emp_designation,
			String gender,
			String emp_city,
			String emp_contact_no,
			String emp_email_id,
			String emp_jointing_date,
			String emp_date_of_birth);
	public List<Employee> displayEmp();
	public String deleteEmp(int e);

}
