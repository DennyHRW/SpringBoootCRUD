package com.employee.employeecrud.service;

import java.util.List;

import com.employee.employeecrud.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	void deleteEmployeeById(String employeeId);
	
	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(String employeeId, Employee employee);
	
	Employee getEmployeeById(String employeeId);
	
	List<Employee> getEmployeeByName(String employeeName);
	
	List<Employee> getEmployeeByPhone(String EmployeePhone);
	
	List<Employee> getEmployeeBy(String employeeName, String EmployeePhone);
	
	long numberOfEmployees(List<Employee> employee);
	

}