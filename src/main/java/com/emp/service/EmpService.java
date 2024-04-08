package com.emp.service;

import java.util.List;

import com.emp.entity.Employee;

public interface EmpService {
   
	Employee createEmp(Employee emp);
	List<Employee> listAllEmps();
	Employee getEmpById(Integer id);
	Employee updateEmp(Integer id,Employee emp);
	Void deleteEmp(Integer id);
}
