package railticket.dao;


import railticket.exception.DbException;
import railticket.seats.Seats;;

public interface SeatsDAO {
	
	public void updateSeatsCount(Seats s) throws DbException;
	
	public void getSeatsCount(Seats s) throws DbException;

}
