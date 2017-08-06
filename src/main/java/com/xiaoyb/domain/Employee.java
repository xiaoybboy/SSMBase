package com.xiaoyb.domain;

import javax.validation.constraints.Pattern;

public class Employee {
	private Integer empId;

	@Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})", message = "用户名必须是2-5位中文或者6-16位英文和数字的组合")
	private String empName;

	private String empGender;

	@Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "邮箱格式不正确")
	private String empEmail;

	private Integer depId;

	private Department department;

	public Employee(Integer empId, String empName, String empGender, String empEmail, Integer depId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.empEmail = empEmail;
		this.depId = depId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender == null ? null : empGender.trim();
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail == null ? null : empEmail.trim();
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGender=" + empGender + ", empEmail="
				+ empEmail + ", depId=" + depId + ", department=" + department + "]";
	}

}