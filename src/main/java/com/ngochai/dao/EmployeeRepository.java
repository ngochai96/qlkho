package com.ngochai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngochai.bean.Employees;

@Repository
@Transactional(rollbackFor=Exception.class)
public class EmployeeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Employees loadEmployeeByUsername(final String username) {
		List<Employees> employees = new ArrayList<Employees>();
		employees = em.createQuery("from Employee where username = ?",Employees.class).setParameter(0, username).getResultList();
		if(employees.size() > 0) {
			return employees.get(0);
		}else {
			return new Employees();
		}
	}
}
