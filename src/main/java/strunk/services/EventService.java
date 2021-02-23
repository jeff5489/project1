package strunk.services;

import java.util.List;

import strunk.models.Form;
import strunk.models.ReimbursementEvent;
import strunk.repositories.ReimbursementEventRepository;
import strunk.repositories.ReimbursementEventRepositoryImpl;

public class EventService {

	public void addEvent(Form form) {
		
		System.out.println("addEvent in EventSerive reached");
		
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		
		ReimbursementEvent event = new ReimbursementEvent();

//		event.setEmployeeId(Integer.parseInt(r.getParameter("employeeId")));
//		event.setType(r.getParameter("courseType"));
//		event.setLocationState(r.getParameter("locationState"));
//		event.setLocationCity(r.getParameter("locationCity"));
//		event.setDescription(r.getParameter("description"));
//		event.setStartDate(r.getParameter("startDate"));
//		event.setEndDate(r.getParameter("endDate"));
//		event.setCost(Double.parseDouble(r.getParameter("cost")));
//		event.setGradingFormat(r.getParameter("gradingFormatId"));
//		event.setPassingGrade(r.getParameter("passingGrade"));
		
		event.setEmployeeId(form.getEmployeeId());
		event.setType(form.getCourseType());
		event.setLocationState(form.getLocationState());
		event.setLocationCity(form.getLocationCity());
		event.setDescription(form.getDescription());
		event.setStartDate(form.getStartDate());
		event.setEndDate(form.getEndDate());
		event.setCost(form.getCost());
		event.setGradingFormat(form.getGradingFormat());
		event.setPassingGrade(form.getPassingGrade());
		
		eRepo.addEvent(event);

	}
	 
	public int getLatestEventId() {
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		eRepo.getEvents();
		
		return 0;
		
	}
	
	public ReimbursementEvent getEvent(int id) {
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		ReimbursementEvent event = eRepo.getEvent(id);
		return event;
	}
	
	public List<ReimbursementEvent> getAllEvents() {
		ReimbursementEventRepository repo = new ReimbursementEventRepositoryImpl();
		return repo.getEvents();
	}
}
