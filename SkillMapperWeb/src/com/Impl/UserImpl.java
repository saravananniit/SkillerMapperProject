package com.Impl;

import com.Model.*;
import java.util.*;
public interface UserImpl {
	public String insertUser(
			int emp_id,
			String password,
			String role,
			String status,
			String remarks);
	public List<User> displayUser();
	public String deleteUser(int u);

}
