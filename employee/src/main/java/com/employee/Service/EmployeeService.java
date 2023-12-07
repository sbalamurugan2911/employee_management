package com.employee.Service;

import com.employee.model.Employee;

public interface EmployeeService {

	public String add(Employee emp);
	public String delete(Integer empId,String name);
    public Employee getEmployee(Integer empId);
    public String update(Employee employee);
}
