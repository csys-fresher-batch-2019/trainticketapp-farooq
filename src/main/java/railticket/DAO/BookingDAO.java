package railticket.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import railticket.booking.Booking;
import railticket.exception.DbException;


public interface BookingDAO {

	public void checkStatusByPnrNumber(long pnrNumber) throws DbException;

	public int bookSeats(int trainnumber,int userId,String boarding,String destination,int noOfSeats,LocalDate date) throws DbException, SQLException, Exception;

	public boolean login(int userid,String password)throws DbException;
	 
	public void Cancellation(int user_id, int train_number,LocalDate traveldate) throws DbException;
	
	public ArrayList<Booking> myBooking(int user_id) throws DbException;
}
