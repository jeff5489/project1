package strunk.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import strunk.models.Form;
import strunk.services.EventService;
import strunk.services.RequestService;

public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Gson gson = new Gson();
	
    public FormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Form controller reached - Served at: ");
//		HttpSession session=request.getSession(); 
//		System.out.println("service sess username: " + session.getAttribute("username"));
//		System.out.println("service sess password: " + session.getAttribute("password"));
		
//		EventService eService = new EventService();
//		Event event = eService
		
		RequestService rService = new RequestService();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		Form form = gson.fromJson(reader, Form.class);
		
		EventService eService = new EventService();
		eService.addEvent(form);
		
		RequestService rService = new RequestService();
		rService.addRequest(form);
	}

}
