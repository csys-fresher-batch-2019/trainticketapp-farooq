package railticket.seats;

import railticket.exception.DbException;
import railticket.seats.Seats;
import railticket.seats.Seatsimplementation;

public class TestgetSeatCount {

	public static void main(String[] args) throws DbException {
		Seatsimplementation obj = new Seatsimplementation();
		Seats s = new Seats();
		s.setTrainnumber(32636);
try {
	obj.getSeatsCount(s);
} catch (Exception e) {
throw new DbException("INVALID DATA");
}
	}

}
