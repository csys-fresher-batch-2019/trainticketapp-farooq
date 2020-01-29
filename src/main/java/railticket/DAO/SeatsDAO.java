package railticket.DAO;


import railticket.seats.Seats;;

public interface SeatsDAO {
	
	public void updateSeatsCount(Seats s) throws Exception;
	
	public void getSeatsCount(Seats s) throws Exception;

}
