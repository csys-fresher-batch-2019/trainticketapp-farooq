package railticket.booking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;

import railticket.TestConnect;
import railticket.DAO.BookingDAO;

public class Bookingimplements implements BookingDAO {

	String passengerName;
	int age;
	String boardingStation;

	

	public void checkStatusByPnrNumber(int pnrNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "select curr_status from booking where pnr_num='" + pnrNumber + "'";

		ResultSet row = stmt.executeQuery(sql);
		if (row.next()) {
			String pnr = row.getString("curr_status");
			System.out.println(pnr);
		}

	}

	public void getPassengernames(int noOfSeats) {

	}

	public void bookSeats(int trainnumber, int userId, String boarding, String destination, int noOfSeats,
			LocalDate date) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		String sql = "select blocklist from registration where user_id='" + userId + "'";

		ResultSet row = connection.createStatement().executeQuery(sql);

		if (row.next()) {
			int status = row.getInt("blocklist");
			if (status == 0) {
				CallableStatement stmt = connection.prepareCall("{call PR_booking_status(?,?,?,?,?,?,?)}");
				stmt.setInt(1, trainnumber);
				stmt.registerOutParameter(2, Types.INTEGER);
				stmt.setInt(3, userId);
				stmt.setString(4, boarding);
				stmt.setString(5, destination);
				java.sql.Date date2 = java.sql.Date.valueOf(date);
				stmt.setDate(7, date2);
				stmt.setInt(6, noOfSeats);
				// System.out.println(noOfSeats);
				stmt.executeQuery();

				String sql2 = "select amount from viewtrain where train_num='" + trainnumber + "'";
				ResultSet row3 = connection.createStatement().executeQuery(sql2);
				if (row3.next()) {
					int amount = row3.getInt("amount");
					System.out.println("BOOKING DETAILS");
					System.out.println("\n");

					String sql4 = "select no_of_seats from booking where travel_date=to_date('" + date2
							+ "','yyyy-MM-dd') and user_id=" + userId + "";
					System.out.println(sql4);
					ResultSet seats = connection.createStatement().executeQuery(sql4);
					if (seats.next()) {
						int seats1 = seats.getInt("no_of_seats");
						int a=seats1*amount;
						System.out.println("AMOUNT TO BE PAID=" + a);

						String sql3 = "update booking set amount=" + a + "where travel_date=to_date('"
								+ date2 + "','yyyy-MM-dd') and user_id=" + userId + "";
						stmt.executeUpdate(sql3);
					}
					String sql5 = "select no_of_seats from bookingQueue where travel_date=to_date('" + date2
							+ "','yyyy-MM-dd') and user_id=" + userId + "";
					ResultSet seats1 = connection.createStatement().executeQuery(sql5);
				
					if (seats1.next()) {
						int seats2 = seats1.findColumn("no_of_seats");
						int b= seats2*amount;
						String sql6 = "update bookingQueue set amount=" + b
								+ "where travel_date=to_date('" + date2 + "','yyyy-MM-dd') and user_id=" + userId + "";
						stmt.executeUpdate(sql6);
						System.out.println("\n");
					}
				}

				String sql1 = "select pnr_num,travel_date from booking where travel_date=to_date('" + date
						+ "','yyyy-MM-dd')";

				ResultSet row1 = connection.createStatement().executeQuery(sql1);
				while (row1.next()) {
					int pnr = row1.getInt("pnr_num");
					Date date1 = row1.getDate("travel_date");
					System.out.println("PNR NUMBER=" + pnr + "\n" + "TRAVEL DATE=" + date1);
					System.out.println("\n");
				}

				System.out.println("BOOKED SUCCESSFULLY");
			

			} else {

				System.out.println("YOUR ACCOUNT IS BLOCKED ");
			}
		}

		//////////// Path path = Paths.get(fileName);
		// byte[] bytes = content.getBytes();
		// Files.write(path, bytes);
		// update on database

	}

	public void login(String emailid, String password) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		String sql1 = "select email_id,pass from registration where email_id = '" + emailid + "' and pass = '"
				+ password + "'";
		System.out.println(sql1);

		ResultSet row = connection.createStatement().executeQuery(sql1);
		if (row.next()) {
			String emailid1 = row.getString("email_id");
			String password1 = row.getString("pass");

			if (emailid1.equals(emailid) && password1.equals(password)) {
				System.out.println("LOGGED IN");
			}
		} else {
			System.out.println("INVALID EMAIL ID OR PASSWORD");
		}

	}

	public String berth_type(int s) {
		// TODO Auto-generated method stub

		if (s > 0 && s < 73)
			if (s % 8 == 1 || s % 8 == 4)
				System.out.println(s + " is lower berth");
			else if (s % 8 == 2 || s % 8 == 5)
				System.out.println(s + " is middle berth");
			else if (s % 8 == 3 || s % 8 == 6)
				System.out.println(s + " is upper berth");
			else if (s % 8 == 7)
				System.out.println(s + " is side lower berth");
			else
				System.out.println(s + " is side upper berth");
		else
			System.out.println(s + " invalid seat number");
		return null;
	}

	

}
