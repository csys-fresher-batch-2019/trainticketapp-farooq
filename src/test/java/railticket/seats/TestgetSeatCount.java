package railticket.seats;

import railticket.seats.Seats;
import railticket.seats.Seatsimplementation;

public class TestgetSeatCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seatsimplementation obj = new Seatsimplementation();
		Seats s = new Seats();
		s.setTrainnumber(32636);
try {
	obj.getSeatsCount(s);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
