package strunk.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import strunk.models.Employee;
import strunk.repositories.EmployeeRepository;
import strunk.repositories.EmployeeRepositoryImpl;

public class LogInService {
	
	public static Gson gson = new Gson();
	
	public void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		boolean isEmployee = false;
//		String employeePosition;
		
		EmployeeRepository repo = new EmployeeRepositoryImpl();
		List<Employee> employees = repo.getAllEmployees();
//		System.out.println(employees);
				
		for(Employee employee : employees) {
			if(username.equals(employee.getUserName())  && password.equals(employee.getPassword())) {
				HttpSession session=request.getSession();  
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("id", employee.getId());
				session.setAttribute("department", employee.getDepartment());
				session.setAttribute("positionTitle", employee.getPositionTitle());
//				isEmployee = true; 
//				employeePosition = employee.getPositionTitle();
				System.out.println("user and pass match: " + employee);
				response.getWriter().append(gson.toJson(employee));
			}else {
				System.out.println("username or password didn't match");
			}
			
		}
		
		
	}

}
