package strunk.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import strunk.models.Employee;
import strunk.services.EmployeeService;

public class FundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FundController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeService service = new EmployeeService();
		Employee employee = service.getEmployee(employeeId);
		System.out.println(employee.toString());
		double fundsAvailable = employee.getAvailableReimbursementAmount();
		String fundsString = String.valueOf(fundsAvailable);
		response.getWriter().append(fundsString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
