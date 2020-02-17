package railticket.registration;

import railticket.booking.Bookingimplements;
import railticket.exception.DbException;

public class TestUserRegister {

	public static void main(String[] args) throws DbException {
		
		Bookingimplements book = new Bookingimplements();
		String user=book.getUserName(1040);
		System.out.println(user);
	}
}
