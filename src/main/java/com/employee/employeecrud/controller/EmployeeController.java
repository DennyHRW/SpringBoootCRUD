package com.employee.employeecrud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.employeecrud.entity.Employee;
import com.employee.employeecrud.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model, @RequestParam(required = false) String name,
			@RequestParam(required = false) String phone) {

		if ((name == "" && phone == "") || (name == null && phone == null)) {
			model.addAttribute("employees", employeeService.getAllEmployees());
			model.addAttribute("numberOfEmployees",
					employeeService.numberOfEmployees(employeeService.getAllEmployees()));
		} else {
			model.addAttribute("employees", employeeService.getEmployeeBy(name, phone));
			model.addAttribute("numberOfEmployees",
					employeeService.numberOfEmployees(employeeService.getEmployeeBy(name, phone)));
		}
		return "employees";
	}

	@GetMapping("/employees/get")
	@ResponseBody
	public Employee employeeById(String id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/employees/add")
	public String saveEmployee(@ModelAttribute("employees") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@PostMapping("/employees/edit/{id}")
	public String updateEmployee(@PathVariable String id, @ModelAttribute("employees") Employee employee) {

		Employee newEmployee = employeeService.getEmployeeById(id);
		newEmployee.setEmployeeId(id);
		newEmployee.setEmployeeName(employee.getEmployeeName());
		newEmployee.setEmployeePhone(employee.getEmployeePhone());
		newEmployee.setDateJoined(employee.getDateJoined());
		newEmployee.setMaxReimbursement(employee.getMaxReimbursement());

		String pattern = "dd-MM-yyyy";
		String newDate = new SimpleDateFormat(pattern).format(new Date());
		newEmployee.setLastUpdated(employee.dateToDMY(newDate));

		employeeService.saveEmployee(newEmployee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

	@GetMapping("/")
	public String redirectToEmployees() {
		return "redirect:/employees";
	}

}
