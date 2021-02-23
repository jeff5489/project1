package strunk.models;

public class Form {
	
	// event
	private int employeeId;
	private String courseType;
	private String locationState;
	private String locationCity;
	private String description;
	private String startDate;
	private String endDate;
	private Double cost;
	private String gradingFormat;
	private String passingGrade;
	
	// request
	private String justification;

	public Form() {
		super();
	}

	public Form(int employeeId, String courseType, String locationState, String locationCity, String description,
			String startDate, String endDate, Double cost, String gradingFormat, String passingGrade,
			String justification) {
		super();
		this.employeeId = employeeId;
		this.courseType = courseType;
		this.locationState = locationState;
		this.locationCity = locationCity;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.passingGrade = passingGrade;
		this.justification = justification;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	@Override
	public String toString() {
		return "Form [employeeId=" + employeeId + ", courseType=" + courseType + ", locationState=" + locationState
				+ ", locationCity=" + locationCity + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", cost=" + cost + ", gradingFormat=" + gradingFormat + ", passingGrade="
				+ passingGrade + ", justification=" + justification + "]";
	}

}
