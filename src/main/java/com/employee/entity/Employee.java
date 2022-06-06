package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private Integer employeeId;
	private String name;
	private String project;
	private String mailId;
	private String phoneNo;
	
	public Employee() {
		
	}
	
	public Employee(Integer employeeId, String name, String project, String mailId, String phoneNo) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.project = project;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", project=" + project + ", mailId=" + mailId
				+ ", phoneNo=" + phoneNo + "]";
	}

}
