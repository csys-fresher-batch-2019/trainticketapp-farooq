package railticket.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import railticket.TestConnect;
import railticket.dao.SeatsDAO;
import railticket.exception.DbException;
import railticket.exception.ErrorMessages;
import railticket.seats.Seats;;


public class Seatsimplementation implements SeatsDAO {

	
	public void updateSeatsCount(Seats s) throws DbException {
	
		String sqk2 = "update total1 set total_seats=?";
		String sql = "update seats set avail_seats=? where train_num=?";
		try(
		Connection connection = TestConnect.getConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
				PreparedStatement stmt1 = connection.prepareStatement(sqk2)){
				stmt1.setInt(1, s.getAvailableseats());
			stmt1.executeUpdate();
stmt.setLong(1, s.getAvailableseats());
stmt.setInt(2, s.getTrainnumber());
			stmt.executeUpdate();
	} catch (Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	}
		
	}
	
	
	public void getSeatsCount(Seats s) throws DbException {
		String sql = "select avail_seats from seats where train_num=?";
		try( 
			Connection connection = TestConnect.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);){
			stmt.setInt(1, s.getTrainnumber());
			
			try(ResultSet row = stmt.executeQuery();){
			
			if(row.next()) {
				String seats = row.getString("avail_seats");
				System.out.println("AVAILABLE SEATS="+seats);
			}
		} catch (Exception e) {
throw new DbException(ErrorMessages.INVALID_DATA);
		}
		
	} catch (SQLException e1) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);		
	} catch (Exception e1) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
	}
	}
}