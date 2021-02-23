package strunk.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import strunk.models.Message;
import strunk.services.MessageService;

public class GetMessagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Gson gson = new Gson();

    public GetMessagesController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		MessageService service = new MessageService();
		List<Message> messages = service.getAllMessages();
		
		response.getWriter().append(gson.toJson(messages));		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
