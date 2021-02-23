package strunk.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import strunk.models.Message;
import strunk.services.MessageService;
import strunk.services.RequestService;

public class AddMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Gson gson = new Gson();

    public AddMessageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
//		BufferedReader reader = request.getReader();
//		Message message = gson.fromJson(reader, Message.class);
		HttpSession session=request.getSession();  
		
		Message message = new Message();
		message.setBody(request.getParameter("body"));
		message.setRequestId(Integer.parseInt(request.getParameter("requestId")));
		int employeeId = (int) session.getAttribute("id");
//		message.setEmployeeId(Integer.parseInt(employeeIdString));
		message.setEmployeeId(employeeId);
		message.setEmployeePosition((String) session.getAttribute("positionTitle"));
		
		MessageService service = new MessageService();
		System.out.println(message);
		service.addMessage(message);
		
	}
}