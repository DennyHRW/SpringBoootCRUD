package com.employee.employeecrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.employeecrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query(value = "SELECT * FROM employees WHERE employee_name LIKE %?1%", nativeQuery = true)
	List<Employee> findByEmployeeName(String employeeName);

	@Query(value = "SELECT * FROM employees WHERE employee_phone LIKE %?1%", nativeQuery = true)
	List<Employee> findByEmployeePhone(String employeePhone);

	@Query(value = "SELECT * FROM employees WHERE employee_phone LIKE %?1% OR employee_name LIKE %?2%", nativeQuery = true)
	List<Employee> findByEmployee(String employeePhone, String employeeName);

}
