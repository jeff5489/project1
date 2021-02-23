package strunk.models;

import java.time.LocalDateTime;

public class Message {
	
	private int id;
	private int employeeId;
	private String employeePosition;
	private int requestId;
	private String dateTime;
	private String body;
	
	public Message() {
		super();
	}
	
	public Message(int id, int employeeId, String employeePosition, int requestId, String dateTime, String body) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.employeePosition = employeePosition;
		this.requestId = requestId;
		this.dateTime = dateTime;
		this.body = body;
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
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", employeeId=" + employeeId + ", employeePosition=" + employeePosition
				+ ", requestId=" + requestId + ", dateTime=" + dateTime + ", body=" + body + "]";
	}
}
