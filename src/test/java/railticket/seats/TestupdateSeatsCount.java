package railticket.seats;

import railticket.seats.Seats;
import railticket.seats.Seatsimplementation;

public class TestupdateSeatsCount {

	public static void main(String[] args) {
		Seatsimplementation obj = new Seatsimplementation();
		Seats s = new Seats();
		s.setAvailableseats(1090);
		s.setTrainnumber(32636);
		try {
			obj.updateSeatsCount(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
