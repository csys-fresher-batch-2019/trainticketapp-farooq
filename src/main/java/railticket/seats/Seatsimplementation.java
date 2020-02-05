package railticket.seats;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import railticket.TestConnect;
import railticket.DAO.SeatsDAO;
import railticket.seats.Seats;;


public class Seatsimplementation implements SeatsDAO {

	
	public void updateSeatsCount(Seats s) throws Exception {
	try {
		Connection connection = TestConnect.getConnection();
		Statement stmt = connection.createStatement();
		String sqk2 = "update total1 set total_seats='"+s.getAvailableseats()+"'";
		stmt.executeUpdate(sqk2);
			String sql = "update seats set avail_seats="+s.getAvailableseats()+"where train_num="+s.getTrainnumber()+"";
			stmt.executeUpdate(sql);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	public void getSeatsCount(Seats s) throws Exception {
		try {
			Connection connection = TestConnect.getConnection();
			Statement stmt = connection.createStatement();
			
			String sql = "select avail_seats from seats where train_num='"+s.getTrainnumber()+"'";
			
			ResultSet row = stmt.executeQuery(sql);
			if(row.next()) {
				String seats = row.getString("avail_seats");
				System.out.println("AVAILABLE SEATS="+seats);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
