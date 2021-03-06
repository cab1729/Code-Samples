package org.cab1729.mvc.controller;

import java.util.Map;

import org.cab1729.mvc.domain.Employee;
import org.cab1729.mvc.service.DepartmentService;
import org.cab1729.mvc.service.EmployeeService;
import org.cab1729.mvc.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobService jobService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/index")
	public String listEmployee(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("employeeList", employeeService.listEmployee());
		// populate selection lists
		map.put("departmentList", departmentService.listDepartments());
		map.put("jobList", jobService.listJobs());
		
		return "employee";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee, 
			BindingResult result) {
		employeeService.addEmployee(employee);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		employeeService.removeEmployee(employeeId);
		return "redirect:/index";
	}

}
