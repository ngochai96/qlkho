package com.ngochai.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity(name="employees")
@Table(name="employees",catalog="qlkho",uniqueConstraints=@UniqueConstraint(columnNames="username"))
public class Employees implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fullname;
//	private String date_birthday;
	private String email;
	private String phone;
	private String address;
	private String username;
	private String password;
//	private Boolean enabled;
	private Set<EmployeeRole> employeeRole = new HashSet<EmployeeRole>(0);
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="fullname",length=20)
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
//	@Column(name="date_birthday",length=10)
//	public String getDate_birthday() {
//		return date_birthday;
//	}
//	public void setDate_birthday(String date_birthday) {
//		this.date_birthday = date_birthday;
//	}
	
	@Column(name="email",length=15)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="phone",length=15)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="address",length=100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="username",length=10,unique=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password",length=255)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	@Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
//	public Boolean getEnabled() {
//		return enabled;
//	}
//	public void setEnabled(Boolean enabled) {
//		this.enabled = enabled;
//	}
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="employees")
	public Set<EmployeeRole> getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(Set<EmployeeRole> employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	@Transient
	public List<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(EmployeeRole eRole : this.employeeRole) {
			authorities.add(new SimpleGrantedAuthority(eRole.getRole().getName()));
		}
		return authorities;
	}
	
}
