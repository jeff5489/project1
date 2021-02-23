package strunk.services;

import strunk.models.Employee;
import strunk.repositories.EmployeeRepository;
import strunk.repositories.EmployeeRepositoryImpl;

public class EmployeeService {
	
	public Employee getEmployee(int employeeId) {
		EmployeeRepository repo = new EmployeeRepositoryImpl();
		Employee employee = repo.getEmployee(employeeId);
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		EmployeeRepository  repo = new EmployeeRepositoryImpl();
		repo.updateEmployee(employee);
	}

}