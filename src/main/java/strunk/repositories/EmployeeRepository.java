package strunk.repositories;

import java.util.List;

import strunk.models.Employee;

public interface EmployeeRepository {
	
	public Employee getEmployee(int id);
	public boolean addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int id);

}
