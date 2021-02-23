package strunk.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import strunk.services.LogInService;

public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogInController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Get position and dept

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("LogIn Servlet - Served at: ").append(request.getContextPath());
//		String username = request.getParameter("username");
//		System.out.println("username: " + username);
//		String password = request.getParameter("password");
//		System.out.println("password: " + password);
		
//		response.set
//		PrintWriter out = response.getWriter();
//        out.print(username + " " + password);
		
//		System.out.println("Log in controller reached");
		
		LogInService logInService = new LogInService();
		logInService.logIn(request, response);
//		if(logInService.logIn(request)) {
//			response.getWriter().append("true");
//		} else {
//			response.getWriter().append("false");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
