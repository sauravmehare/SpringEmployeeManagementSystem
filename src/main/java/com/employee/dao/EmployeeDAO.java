package com.employee.dao;


import java.util.List;

import com.employee.entity.Employee;


public interface EmployeeDAO {
	void saveEmployee(Employee employee);
	void deleteEmployee(int employeeID);
	void updateEmployee(Employee employee);
	Employee getEmployee(int employeeID);
	List<Employee> getAllEmp();
}
