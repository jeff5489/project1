package strunk.repositories;

import java.util.List;

import strunk.models.ReimbursementRequest;

public interface ReimbursementRequestRepository {
	
	public ReimbursementRequest getRequest(int id);
	public List getAllRequests();
	public boolean addRequest(ReimbursementRequest request);
	public boolean updateRequest(ReimbursementRequest request);
	public boolean deleteRequestion(int id);
}
