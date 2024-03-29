package com.ngochai.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role",catalog="qlkho")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Set<EmployeeRole> employeeRole = new HashSet<EmployeeRole>(0);
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="role")
	public Set<EmployeeRole> getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(Set<EmployeeRole> employeeRole) {
		this.employeeRole = employeeRole;
	}
}
