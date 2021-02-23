package strunk.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import strunk.services.RequestService;

public class RequestApprover extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestApprover() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		HttpSession session=request.getSession();  
		System.out.println("requestIdApproved"+request.getParameter("requestIdApproved"));
		
		System.out.println("current user's id: "+session.getAttribute("id"));
		response.getWriter().append(request.getParameter("requestIdApproved"));
		
		RequestService service = new RequestService();
		service.approve(request);
	}

}
