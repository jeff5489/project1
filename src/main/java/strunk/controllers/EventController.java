package strunk.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import strunk.models.ReimbursementEvent;
import strunk.services.EventService;

public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Gson gson = new Gson();

    public EventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EventService service = new EventService();
		List<ReimbursementEvent> events = service.getAllEvents();
		
		response.getWriter().append(gson.toJson(events));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
