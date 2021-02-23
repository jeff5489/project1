package strunk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import strunk.models.ReimbursementEvent;
import strunk.models.ReimbursementRequest;
import strunk.util.JDBCConnection;

public class ReimbursementEventRepositoryImpl implements ReimbursementEventRepository {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public ReimbursementEvent getEvent(int id) {
		try {
			System.out.println("getEvent in event repo reached");
			String sql = "SELECT * FROM reimbursementEvents WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();
			System.out.println("line 28 in repo reached");
			if (rs.next()) {
				System.out.println("line 30 in repo reached");
				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));
				event.setEmployeeId(rs.getInt("employeeId"));
				event.setType(rs.getString("type"));
				event.setLocationState(rs.getString("locationState"));
				event.setLocationCity(rs.getString("locationCity"));
				event.setStartDate(rs.getString("startDate"));
				event.setEndDate(rs.getString("endDate"));
				event.setCost(rs.getDouble("cost"));
				event.setGradingFormat(rs.getString("gradingFormatId"));
//				conn.close();
				System.out.println("event repo line 42: " + event);
				return event;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public int getEventId(String type) {
		try {

			String sql = "SELECT * FROM reimbursementRequests WHERE type = created by RequestService";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
//				ReimbursementEvent event = new ReimbursementEvent();
//				event.setId(rs.getInt("id"));
//				event.setEmployeeId(rs.getInt("employeeId"));
//				event.setRequestId(rs.getInt("requestId"));
//				event.setType(rs.getString("type"));
//				event.setLocation(rs.getString("location"));
//				event.setStartDate(rs.getString("startDate"));
//				event.setEndDate(rs.getString("endDate"));
//				event.setCost(rs.getDouble("cost"));
//				event.setGradingFormat(rs.getString("gradingFormat"));
				conn.close();
				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean addEvent(ReimbursementEvent event) {
		try {
			
//			private int id;
//			private int employeeId;
//			private int requestId;
//			private String type;
//			private String location;
//			private String description;
//			private String startDate;
//			private String endDate;
//			private Double cost;
//			private String gradingFormat;
			
			String sql = "INSERT into reimbursementEvents (id, employeeId, type, locationState, locationCity, description, startDate, "
					+ "endDate, cost, gradingFormatId, passingGrade)"
					+ "values (reimbursementEvents_seq.nextval ,?,?,?,?,?,?,?,?,?,?)";
		    
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, event.getEmployeeId());
			ps.setString(2, event.getType());
			ps.setString(3, event.getLocationState());
			ps.setString(4, event.getLocationCity());
			ps.setString(5, event.getDescription());
			ps.setString(6, event.getStartDate());
			ps.setString(7, event.getEndDate());
			ps.setDouble(8, event.getCost());
			ps.setString(9, event.getGradingFormat());
			ps.setString(10, event.getPassingGrade());

			ps.execute();
//			conn.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<ReimbursementEvent> getEvents() {
		List<ReimbursementEvent> events = new ArrayList<ReimbursementEvent>();

		try {

			String sql = "SELECT * FROM reimbursementEvents order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));
				event.setEmployeeId(rs.getInt("employeeId"));
				event.setType(rs.getString("type"));
				event.setLocationState(rs.getString("locationState"));
				event.setLocationCity(rs.getString("locationCity"));
				event.setStartDate(rs.getString("startDate"));
				event.setEndDate(rs.getString("endDate"));
				event.setCost(rs.getDouble("cost"));
				event.setGradingFormat(rs.getString("gradingFormatId"));
				events.add(event);

			}
//			conn.close();
			return events;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateEvent(ReimbursementEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvent(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getLatestEventId() {
		
		List<ReimbursementEvent> events = new ArrayList<ReimbursementEvent>();
		
		try {
//			conn.setNetworkTimeout(null, 6000);
			System.out.println("conn.getNetworkTimeout: " + conn.getNetworkTimeout());
//			conn.getNetworkTimeout();
			
			String sql = "SELECT * FROM reimbursementEvents ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
//			pool.setValidateConnectionOnBorrow(true);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));

				events.add(event);
				
			}

			int id = events.get(0).getId();
//			conn.close();
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
