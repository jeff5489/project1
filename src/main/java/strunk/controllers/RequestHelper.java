package strunk.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch (uri) {
		
		case "/approve": {
			System.out.println("Request helper class working for /approve");
			response.getWriter().append("Request helper class working for /approve");
			break;
		}
//		case "/ActorApp/addActor.do": { 
////			ActorController.addActor(request, response);
//			break;
//		}
//		case "/ActorApp/addMovie.do": {
////			MovieController.addMovie(request, response);
//			break;
//		}
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot.");
			break;
		}
		}

	}

}
