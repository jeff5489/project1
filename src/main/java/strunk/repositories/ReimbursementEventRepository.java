package strunk.repositories;

import java.util.List;

import strunk.models.ReimbursementEvent;

public interface ReimbursementEventRepository {
	
	public ReimbursementEvent getEvent(int id);
	public boolean addEvent(ReimbursementEvent event);
	public List<ReimbursementEvent> getEvents();
	public boolean updateEvent(ReimbursementEvent event);
	public boolean deleteEvent(int id);
	public int getLatestEventId();

}
