package strunk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import strunk.models.ReimbursementRequest;
import strunk.services.RequestService;
import strunk.util.JDBCConnection;

public class ReimbursementRequestRepositoryImpl implements ReimbursementRequestRepository {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public ReimbursementRequest getRequest(int id) {
		try {

			String sql = "SELECT * FROM reimbursementRequests WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();
				request.setId(rs.getInt("id"));
				request.setEmployeeId(rs.getInt("employeeId"));
				request.setEventId(rs.getInt("eventId"));
				request.setStatus(rs.getString("status"));
				request.setDateOfSubmission(rs.getString("dateOfSubmission"));
				request.setWorkRelatedJustification(rs.getString("workRelatedJustification"));
				request.setUrgent(rs.getBoolean("isUrgent"));
				request.setBencoApproved(rs.getBoolean("bencoApproved"));
				request.setSupervisorApproved(rs.getBoolean("supervisorApproved"));
				request.setDepartmentHeadApproved(rs.getBoolean("departmentHeadApproved"));
//				conn.close();
				return request;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List getAllRequests() {
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();

		try {

			String sql = "SELECT * FROM reimbursementRequests order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ReimbursementRequest request = new ReimbursementRequest();
				request.setId(rs.getInt("id"));
				request.setEmployeeId(rs.getInt("employeeId"));
				request.setEventId(rs.getInt("eventId"));
				request.setStatus(rs.getString("status"));
				request.setDateOfSubmission(rs.getString("dateOfSubmission"));
				request.setWorkRelatedJustification(rs.getString("workRelatedJustification"));
				request.setUrgent(rs.getBoolean("isUrgent"));
				request.setBencoApproved(rs.getBoolean("bencoApproved"));
				request.setSupervisorApproved(rs.getBoolean("supervisorApproved"));
				request.setDepartmentHeadApproved(rs.getBoolean("departmentHeadApproved"));
				
				requests.add(request);

			}
//			conn.close();
			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean addRequest(ReimbursementRequest request) {
		try {
			
			String sql = "INSERT into reimbursementRequests values (reimbursementRequests_seq.nextval ,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request.getEmployeeId()));
			ps.setString(2, Integer.toString(request.getEventId()));
			ps.setString(3, request.getStatus());
			ps.setString(4, request.getDateOfSubmission());
			ps.setString(5, request.getWorkRelatedJustification());
			int urgent = request.urgent() == false ? 0 : 1;
			ps.setInt(6, urgent);
			int isBencoApproved = request.isBencoApproved() == false ? 0 : 1;
			ps.setInt(7, isBencoApproved);
			int isSupervisorApproved = request.isSupervisorApproved() == false ? 0 : 1;
			ps.setInt(8, isSupervisorApproved);
			int isDepartmentHeadApproved = request.urgent() == false ? 0 : 1;
			ps.setInt(9, isDepartmentHeadApproved);

			ps.execute();
//			conn.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean updateRequest(ReimbursementRequest request) {
		try {
			int id = request.getId();
			
			String sql = "UPDATE reimbursementRequests SET status = ?, BencoApproved = ?, SupervisorApproved =?, DepartmentHeadApproved = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, request.getStatus());
//			int urgent = request.urgent() == false ? 0 : 1;
//			ps.setInt(2, urgent);
			int isBencoApproved = request.isBencoApproved() == false ? 0 : 1;
			ps.setInt(2, isBencoApproved);
			int isSupervisorApproved = request.isSupervisorApproved() == false ? 0 : 1;
			ps.setInt(3, isSupervisorApproved);
			int isDepartmentHeadApproved = request.isDepartmentHeadApproved() == false ? 0 : 1;
			ps.setInt(4, isDepartmentHeadApproved);
			ps.setInt(5, request.getId());

			ps.execute();
			
			RequestService service = new RequestService();
			System.out.println("service.updateFunds next - Request id: " + id);
			service.updateFunds(id);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteRequestion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
