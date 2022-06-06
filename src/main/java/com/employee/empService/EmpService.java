package com.employee.empService;

import java.util.List;

import com.employee.entity.Employee;

public interface EmpService {
	void saveEmployee(Employee employee);
	void deleteEmployee(int employeeID);
	void updateEmployee(Employee employee);
	Employee getEmployee(int employeeID);
	List<Employee> getAllEmp();
}
