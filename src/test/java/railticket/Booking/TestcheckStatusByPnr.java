package railticket.Booking;

import railticket.dao.*;
import railticket.exception.DbException;
import railticket.booking.Bookingimplements;

public class TestcheckStatusByPnr {

	public static void main(String[] args) throws DbException {
		
	BookingDAO obj = new Bookingimplements();
	try {
		obj.checkStatusByPnrNumber(136905687);
	} catch (DbException e) {
		throw new DbException("NO METHOD FOUND");
	}

	}

}
