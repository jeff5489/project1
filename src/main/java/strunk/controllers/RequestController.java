package strunk.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import strunk.models.Employee;
import strunk.models.ReimbursementRequest;
import strunk.services.RequestService;

public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Gson gson = new Gson();

    public RequestController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		String uri = request.getRequestURI();
//		if(uri.equals("/approve")) {
//			RequestHelper.process(request, response);
//		}
		
		RequestService service = new RequestService();
		List<ReimbursementRequest> requests = service.getAllRequests();
		
//		Employee e = new Employee();
//		e.setFirstName("Doug");
//		e.setPositionTitle("Batman");
		
		response.getWriter().append(gson.toJson(requests));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
