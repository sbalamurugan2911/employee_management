package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Service.EmployeeService;
import com.employee.Service.EmployeeServiceImp;
import com.employee.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImp empService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	@GetMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView mv = new ModelAndView("addEmployee");
		
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView add(Employee emp) {
		ModelAndView mv = new ModelAndView("addMassage");
		String add=empService.add(emp);
		mv.addObject("result",add);
		return mv;
	}
	
	@GetMapping("/updateEmployee")
	public ModelAndView updateEmployee() {
		ModelAndView mv = new ModelAndView("updateEmployee");
		
		return mv;
	}
	
	@GetMapping("/updatePage")
	public ModelAndView updatePage(@RequestParam Integer empId) {
		ModelAndView mv = new ModelAndView();
		Employee employee = empService.getEmployee(empId);
		if(employee.getEmpId()!=null) {
			mv.addObject("Employee", employee);
			mv.setViewName("updatePage");
			return mv;
		}else {
			mv.setViewName("invalid");
		}
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(Employee employee) {
		ModelAndView mv = new ModelAndView("updateMassage");
		String update=empService.update(employee);
		mv.addObject("result", update);
		
		return mv;
	}
	
	
	
	@GetMapping("/deleteEmployee")
	public ModelAndView deleteEmployee() {
		ModelAndView mv = new ModelAndView("deleteEmployee");
		
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam Integer empId,@RequestParam String name) {
		ModelAndView mv = new ModelAndView("deleteMassage");
		String delete=empService.delete(empId,name);
		mv.addObject("result",delete);
		return mv;
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception() {
		ModelAndView mv = new ModelAndView("invalid");
		return mv;
		}

}
