package com.employee.employeecrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	public Employee() {

	}

	public Employee(String employeeId, String employeeName, String employeePhone, int maxReimbursement,
			String dateJoined, String dateCreated, String lastUpdated) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.maxReimbursement = maxReimbursement;
		this.dateJoined = dateJoined;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_phone")
	private String employeePhone;

	@Column(name = "limit_reimbursement")
	private int maxReimbursement;

	@Column(name = "date_joined")
	private String dateJoined;

	@Column(name = "date_created")
	private String dateCreated;

	@Column(name = "last_updated")
	private String lastUpdated;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public int getMaxReimbursement() {
		return maxReimbursement;
	}

	public void setMaxReimbursement(int maxReimbursement) {
		this.maxReimbursement = maxReimbursement;
	}

	public String getDateJoined() {
		return (dateJoined);
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getDateCreated() {
		return (dateCreated);
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLastUpdated() {
		return (lastUpdated);
	}
	
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public String dateToDMY(String date) {
		String[] dateYMD = date.split("-");
		int count = (dateYMD.length) - 1;
		StringBuilder dateDMY = new StringBuilder();
		
		for (String string : dateYMD) {
			if(count == 0) dateDMY.insert(0, string);
			else dateDMY.insert(0, "-" + string); count--; }
		return dateDMY.toString();
	}

}