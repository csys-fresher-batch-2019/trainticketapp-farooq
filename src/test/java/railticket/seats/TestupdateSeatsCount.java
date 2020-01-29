package railticket.seats;

import railticket.seats.Seats;
import railticket.seats.Seatsimplementation;

public class TestupdateSeatsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Seatsimplementation obj = new Seatsimplementation();
Seats s = new Seats();
s.setAvailableseats(1090);
s.setTrainnumber(32636);
try {
	obj.updateSeatsCount(s);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
