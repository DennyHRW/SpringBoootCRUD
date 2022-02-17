package com.employee.employeecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeecrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeecrudApplication.class, args);
	}

	/*
	 * INSERT INTO `employees`(`employee_id`, `employee_name`, `employee_phone`,
	 * `date_joined`, `limit_reimbursement`, `date_created`, `last_updated`) VALUES
	 * ('0a00','abca','0245','2022-01-01','5','2022-02-02','2022-01-15')
	 */

}
