package strunk.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import strunk.models.Employee;
import strunk.models.Form;
import strunk.models.ReimbursementEvent;
import strunk.models.ReimbursementRequest;
import strunk.repositories.ReimbursementEventRepository;
import strunk.repositories.ReimbursementEventRepositoryImpl;
import strunk.repositories.ReimbursementRequestRepository;
import strunk.repositories.ReimbursementRequestRepositoryImpl;

public class RequestService {
	
	public void addRequest(Form form) {
		
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		ReimbursementEventRepository eventRepo = new ReimbursementEventRepositoryImpl();
		
//		ReimbursementEvent event = new ReimbursementEvent();
		int eventId = eventRepo.getLatestEventId();
		
		ReimbursementRequest request = new ReimbursementRequest();
		// request id
//		request.setEmployeeId(Integer.parseInt(r.getParameter("employeeId")));
//		request.setEventId(eventId); 
//		request.setStatus("In Process"); 
//		request.setDateOfSubmission(java.time.LocalDate.now().toString()); // current date java.time.LocalDate.now()
//		request.setWorkRelatedJustification(r.getParameter("justification"));
//		request.setUrgent(false); // check if urgent by comparing dates
//		request.setBencoApproved(false); 
//		request.setSupervisorApproved(false); 
//		request.setDepartmentHeadApproved(false); 
//		repo.addRequest(request);
		
		request.setEmployeeId(form.getEmployeeId());
		request.setEventId(eventId); 
		request.setStatus("In Process"); 
		request.setDateOfSubmission(java.time.LocalDate.now().toString()); // current date java.time.LocalDate.now()
		request.setWorkRelatedJustification(form.getJustification());
		request.setUrgent(false); // check if urgent by comparing dates
		request.setBencoApproved(false); 
		request.setSupervisorApproved(false); 
		request.setDepartmentHeadApproved(false); 
		repo.addRequest(request);
		
	}
	
	public List getAllRequests() {
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		List<ReimbursementRequest> requests = new ArrayList();
		requests = repo.getAllRequests();
		
		return requests;
	}
	
	public void approve(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		int approverId = (Integer) session.getAttribute("id");
		String approverPositionTitle = (String) session.getAttribute("positionTitle");
		int requestIdApproved = Integer.parseInt(request.getParameter("requestIdApproved"));
		
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		ReimbursementRequest r = repo.getRequest(requestIdApproved);
		
//		System.out.println("request for adding an approval: "+r.toString());
		
		if(approverPositionTitle.equals("Supervisor")) {
			r.setSupervisorApproved(Boolean.TRUE);
		} else if (approverPositionTitle.equals("Department Head")) {
			r.setDepartmentHeadApproved(Boolean.TRUE);
		} else if (approverPositionTitle.equals("Benco")) {
			r.setBencoApproved(Boolean.TRUE);
		}
		
		repo.updateRequest(r);
		// add message saying person of this title approved
		
	}
	
	public void deny(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		int denierId = (Integer) session.getAttribute("id");
		String denierPositionTitle = (String) session.getAttribute("positionTitle");
//		System.out.println("requestIdDenied");
		int requestIdDenied = Integer.parseInt(request.getParameter("requestIdDenied"));
		
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		ReimbursementRequest r = repo.getRequest(requestIdDenied);
		r.setStatus("Denied");
		repo.updateRequest(r);
		
	}
	
	public void updateFunds(int requestId) {
		System.out.println("updateFundes in request service reached");
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		ReimbursementRequest request = repo.getRequest(requestId);
		if(request.isSupervisorApproved() == Boolean.TRUE && request.isDepartmentHeadApproved() == Boolean.TRUE && request.isBencoApproved() == Boolean.TRUE) {
			int eventId = request.getEventId();
			System.out.println("105 eventId: " + eventId);
			EventService eventService = new EventService();
			ReimbursementEvent event = new ReimbursementEvent();
			event = eventService.getEvent(eventId);
			System.out.println("line 108 requestService - event: " + event.toString());
			double cost = event.getCost();
			
			EmployeeService employeeService = new EmployeeService();
			Employee employee = employeeService.getEmployee(request.getEmployeeId());
			double currentFunds = employee.getAvailableReimbursementAmount();
			
			if(currentFunds - cost >= 0) {
				employee.setAvailableReimbursementAmount(currentFunds - cost);
			} else if (currentFunds - cost < 0) { // 500-600
				employee.setAvailableReimbursementAmount(0);
			}
			
			employeeService.updateEmployee(employee);
			
		}
	}
}
