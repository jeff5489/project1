package strunk.models;

public class Employee {
	
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String positionTitle;
	private String department;
	private double availableReimbursementAmount;

	public Employee(String userName, String password, String firstName, String lastName, String positionTitle,
			String department, double availableReimbursementAmount) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionTitle = positionTitle;
		this.department = department;
		this.availableReimbursementAmount = availableReimbursementAmount;
	}

	public Employee(int id, String userName, String password, String firstName, String lastName, String positionTitle,
			String department, double availableReimbursementAmount) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionTitle = positionTitle;
		this.department = department;
		this.availableReimbursementAmount = availableReimbursementAmount;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public double getAvailableReimbursementAmount() {
		return availableReimbursementAmount;
	}

	public void setAvailableReimbursementAmount(double availableReimbursementAmount) {
		this.availableReimbursementAmount = availableReimbursementAmount;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", positionTitle=" + positionTitle + ", department=" + department
				+ ", availableReimbursementAmount=" + availableReimbursementAmount + "]";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
