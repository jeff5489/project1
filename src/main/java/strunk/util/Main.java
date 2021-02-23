package strunk.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import strunk.models.ReimbursementEvent;
import strunk.repositories.ReimbursementEventRepositoryImpl;

public class Main {

	public static void main(String[] args) {

//		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
//		Employee john = new Employee("john", "pass", "John", "Doe", "associate", "accounting", 2000);
//		Employee tom = new Employee("tom", "pass", "Tom", "Doe", "associate", "sales", 2000);
//		Employee rick = new Employee("rick", "pass", "Rick", "Doe", "supervisor", "accounting", 2000);
//		Employee harry = new Employee("harry", "pass", "Harry", "Doe", "associate", "hit squad", 2000);
//		employeeRepository.addEmployee(john);
//		employeeRepository.addEmployee(tom);
//		employeeRepository.addEmployee(rick);
//		employeeRepository.addEmployee(harry);
		
//		EmployeeRepository repo = new EmployeeRepositoryImpl();
//		List<Employee> employees = repo.getAllEmployees();
//		System.out.println(employees);
		
		Connection conn = JDBCConnection.getConnection();
		
		try {

			String sql = "INSERT into reimbursementEvents values (reimbursementEvents_seq.nextval ,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1 , 42);
			ps.setString(2, "type");
//			ps.setInt(3, 1);
			ps.setString(3, "location");
			ps.setString(4, "endDate");
			ps.setString(5, "startDate");
			ps.setString(6, "endDate");
			ps.setInt(7, 9000);
			ps.setString(8, "gradingFormat");
			ps.setString(9, "passingGrade");

			System.out.println("before ps.excute");
			ps.execute();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
