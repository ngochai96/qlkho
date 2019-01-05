package com.ngochai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ngochai.bean.Employees;
import com.ngochai.dao.EmployeeRepository;

@Service
public class EmployeeServices implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public UserDetails loadUserByUsername(final String username) {
		Employees employees = employeeRepository.loadEmployeeByUsername(username);
		if(employees == null) {
			return null;
		}
		
		return new User(username, employees.getPassword(),true,true,true,true,employees.getAuthorities());
	}
}
