package strunk.models;

import java.time.LocalDate;

public class ReimbursementRequest {
	
	private int id;
	private int employeeId;
	private int eventId;
	private String status;
	private String dateOfSubmission;
	private String workRelatedJustification;
	private boolean urgent;
	private boolean bencoApproved;
	private boolean supervisorApproved;
	private boolean departmentHeadApproved;
	
	// Statuses - Urgent, Approved, In Process
	
	public ReimbursementRequest(int employeeId, int eventId, String status, String dateOfSubmission,
			String workRelatedJustification, boolean urgent, boolean bencoApproved, boolean supervisorApproved,
			boolean departmentHeadApproved) {
		super();
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.status = status;
		this.dateOfSubmission = dateOfSubmission;
		this.workRelatedJustification = workRelatedJustification;
		this.urgent = urgent;
		this.bencoApproved = bencoApproved;
		this.supervisorApproved = supervisorApproved;
		this.departmentHeadApproved = departmentHeadApproved;
	}
	public ReimbursementRequest() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
	public String getWorkRelatedJustification() {
		return workRelatedJustification;
	}
	public void setWorkRelatedJustification(String workRelatedJustification) {
		this.workRelatedJustification = workRelatedJustification;
	}
	public boolean urgent() {
		return urgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.urgent = urgent;
	}
	public boolean isBencoApproved() {
		return bencoApproved;
	}
	public void setBencoApproved(boolean bencoApproved) {
		this.bencoApproved = bencoApproved;
	}
	public boolean isSupervisorApproved() {
		return supervisorApproved;
	}
	public void setSupervisorApproved(boolean supervisorApproved) {
		this.supervisorApproved = supervisorApproved;
	}
	public boolean isDepartmentHeadApproved() {
		return departmentHeadApproved;
	}
	public void setDepartmentHeadApproved(boolean departmentHeadApproved) {
		this.departmentHeadApproved = departmentHeadApproved;
	}
	@Override
	public String toString() {
		return "ReimbursementRequest [id=" + id + ", employeeId=" + employeeId + ", eventId=" + eventId + ", status="
				+ status + ", dateOfSubmission=" + dateOfSubmission + ", workRelatedJustification="
				+ workRelatedJustification + ", urgent=" + urgent + ", bencoApproved=" + bencoApproved
				+ ", supervisorApproved=" + supervisorApproved + ", departmentHeadApproved=" + departmentHeadApproved
				+ "]";
	}
	
	/* Optional - event related attachment pdf, png, jpeg, txt, doc file
	*  Optional - attachments of approvals already provided in email, approval type
	*  Optional - work time that will be missed
	*/ 
	 
}
