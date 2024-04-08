package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee createEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> listAllEmps() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee updateEmp(Integer id, Employee emp) {
		// TODO Auto-generated method stub
		Optional<Employee> e = empRepo.findById(id);
		Employee e1 = null;
	    if(e.isPresent()) {
	    	e1 = empRepo.save(e.get());
	    }
	    else {
	    	throw new RuntimeException("Emp not found!");
	    }
	    
		return e1;
	}

	@Override
	public Void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		return null;
	}

	@Override
	public Employee getEmpById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = empRepo.findById(id);
		Employee e1 = null;
		if(e.isPresent()) {
			e1= e.get();
		}
		else {
			throw new RuntimeException("Emp not found!");
		}
		return e1;
	}

}
