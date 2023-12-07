package com.employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Repository.EmployeeRepository;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRep;

	public String add(Employee emp) {
		
		Integer id=emp.getEmpId();
		
		if(employeeRep.findById(id).isEmpty()) {
			employeeRep.save(emp);
			return "Employee added successfully";
		}
		
		return "Employee already exist with same id";
	}

	@Override
	public String delete(Integer id,String name) {
		
		if(!employeeRep.findById(id).isEmpty()) {
			if(employeeRep.findById(id).get().getName().equals(name)) {
				employeeRep.deleteById(id);
				return "Employee details deleted successfully";
			}
		}
		
		
		return "Employee deletion is failed";
	}

	@Override
	public Employee getEmployee(Integer empId) {
		if(!employeeRep.findById(empId).isEmpty()) {
		   return employeeRep.findById(empId).get();
		}
		return new Employee();
	}

	public String update(Employee employee) {
		Integer id=employee.getEmpId();
		if(id!=null) {
			employeeRep.save(employee);
			return "update succecfully!";
		}
		return "update failed" ;
	}

}
