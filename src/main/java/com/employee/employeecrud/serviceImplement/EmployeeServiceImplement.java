package com.employee.employeecrud.serviceImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employeecrud.entity.Employee;
import com.employee.employeecrud.repository.EmployeeRepository;
import com.employee.employeecrud.service.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeById(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public long numberOfEmployees(List<Employee> employee) {
		return Long.valueOf(employee.size());
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		return employeeRepository.findByEmployeeName(employeeName);
	}

	@Override
	public List<Employee> getEmployeeByPhone(String employeePhone) {
		return employeeRepository.findByEmployeePhone(employeePhone);
	}

	@Override
	public List<Employee> getEmployeeBy(String employeeName, String employeePhone) {
		if ((employeeName != "" && employeePhone == "") || (employeeName != null && employeePhone == null))
			return employeeRepository.findByEmployeeName(employeeName);
		if ((employeePhone != "" && employeeName == "") || (employeePhone != null && employeeName == null))
			return employeeRepository.findByEmployeePhone(employeePhone);

		return employeeRepository.findByEmployee(employeePhone, employeeName);

	}

}
