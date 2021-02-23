package strunk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import strunk.models.Employee;
import strunk.models.ReimbursementEvent;
import strunk.services.RequestService;
import strunk.util.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(int id) {
		try {

			String sql = "SELECT * FROM employees where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("ID"));
				e.setUserName(rs.getString("userName"));
				e.setPassword(rs.getString("password"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setPositionTitle(rs.getString("positionTitle"));
				e.setDepartment(rs.getString("department"));
				e.setAvailableReimbursementAmount(rs.getInt("availableReimbursementAmount"));	
				
//				conn.close();
				return e;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		try {

			String sql = "INSERT into employees VALUES (employees_seq.nextval ,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getUserName());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			ps.setString(5, employee.getPositionTitle());
			ps.setString(6, employee.getDepartment());
			ps.setString(7, Double.toString(employee.getAvailableReimbursementAmount()));

			ps.execute();
//			conn.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		try {

			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("ID"));
				e.setUserName(rs.getString("userName"));
				e.setPassword(rs.getString("password"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setPositionTitle(rs.getString("positionTitle"));
				e.setDepartment(rs.getString("department"));
				e.setAvailableReimbursementAmount(rs.getInt("availableReimbursementAmount"));
				employees.add(e);
				
				
			}
//			conn.close();
			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {

			String sql = "UPDATE employees SET availableReimbursementAmount = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(employee.getAvailableReimbursementAmount()));
			ps.setString(2, String.valueOf(employee.getId()));

			ps.execute();
			
//			RequestService service = new RequestService();
//			service.updateFunds(request.getId());
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		return false;
	}

}
