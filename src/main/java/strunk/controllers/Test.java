package strunk.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import strunk.models.Employee;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Gson gson = new Gson();

    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Test Servlet - Served at: ").append(request.getContextPath());
//		System.out.println("Test servlet reached");
//		String param1 = request.getParameter("param1");
//		System.out.println(param1);
		
//		BufferedReader reader = request.getReader();
		
//		Employee e = gson.fromJson(reader, Employee.class);
//		e.setFirstName("Doug");
//		e.setPositionTitle("Batman");
//		System.out.println(e);
//		response.getWriter().append(gson.toJson(e));
		
		Employee e = new Employee();
		e.setFirstName("Doug");
		e.setPositionTitle("Batman");
		
//		gson.toJson(e);
		response.getWriter().append(gson.toJson(e));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
