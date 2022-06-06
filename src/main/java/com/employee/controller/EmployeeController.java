package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.empService.EmpService;
import com.employee.empServiceImpl.EmpServiceImpl;
import com.employee.entity.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpService empService;
	
	@PostMapping(value="/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		empService.saveEmployee(employee);
		return employee;
	}
	
	@DeleteMapping(value="/employee")
	public void deleteEmployee(@RequestBody Employee employee) {
		empService.deleteEmployee(employee.getEmployeeId());
		//return employee;
	}
	
	@PutMapping(value="/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		empService.updateEmployee(employee);
		return employee;
	}
	
	@PostMapping(value="/employees")
	public List<Employee> getall() {
		List<Employee> employees=empService.getAllEmp();
		return employees;
	}

}
