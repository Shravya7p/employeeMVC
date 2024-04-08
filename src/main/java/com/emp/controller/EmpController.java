package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.entity.Employee;
import com.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
    
	@GetMapping({"/","/emps"})
	public String getAllEmps(Model model) {
		model.addAttribute("listEmps", empService.listAllEmps());
		return "index";
	}
	@GetMapping("/showNewEmpForm")
	public String showNewEmpForm(Model model) {
		Employee e = new Employee();
		model.addAttribute("emp", e);
		return "newEmp";
	}
	
	@PostMapping("/saveEmp")
	public String postEmp(@ModelAttribute Employee emp) {
		empService.createEmp(emp);
		return "redirect:/";
		
	}
	
	@GetMapping("/empUpdate/{id}")
	public String updateEmp(@PathVariable Integer id, Model model) {
		Employee e = empService.getEmpById(id);
		model.addAttribute("emp", e);
		return "update_emp";
	}
	
	@GetMapping("/empDelete/{id}")
	public String deleteEmp(@PathVariable Integer id,Model model) {
		empService.deleteEmp(id);
		return "redirect:/";
	}

}
