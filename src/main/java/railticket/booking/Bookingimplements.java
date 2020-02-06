package railticket.booking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import railticket.TestConnect;
import railticket.dao.Logger;
import railticket.exception.DbException;

public class Bookingimplements implements railticket.dao.BookingDAO {

	String passengerName;
	int age;
	String boardingStation;
Logger logger = Logger.getInstance();
	public void checkStatusByPnrNumber(long pnrNumber) throws DbException {

		String sql = "select curr_status from booking where pnr_num=?";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setLong(1, pnrNumber);
			try (ResultSet row = stmt.executeQuery();) {

				if (row.next()) {
					String pnr = row.getString("curr_status");
					System.out.println(pnr);
				}

			}catch (SQLException e) {
throw new DbException("INVALID SQL QUERY");
			}
		} catch (Exception e) {
				throw new DbException("INVALID PNR NUMBER");
			}
			}
			

	public void getPassengernames(int noOfSeats) {

	}

	public int bookSeats(int trainnumber, int userId, String boarding, String destination, int noOfSeats,
			LocalDate date) throws Exception {
		Connection connection = TestConnect.getConnection();

		String sql = "select blocklist from registration where user_id='" + userId + "'";

		ResultSet row = connection.createStatement().executeQuery(sql);

		int a = 0;
		if (row.next()) {
			int status = row.getInt("blocklist");
			if (status == 0) {
				CallableStatement stmt = connection.prepareCall("{call PR_booking_status(?,?,?,?,?,?)}");
				stmt.setInt(1, trainnumber);
				// stmt.registerOutParameter(2, Types.INTEGER);
				stmt.setInt(2, userId);
				stmt.setString(3, boarding);
				stmt.setString(4, destination);
				java.sql.Date date2 = java.sql.Date.valueOf(date);
				stmt.setDate(6, date2);
				stmt.setInt(5, noOfSeats);
				System.out.println(noOfSeats);
				stmt.executeQuery();
				String sql2 = "select amount from viewtrain where train_num='" + trainnumber + "'";
				ResultSet row3 = connection.createStatement().executeQuery(sql2);
				if (row3.next()) {
					int amount = row3.getInt("amount");
					System.out.println("BOOKING DETAILS");
					System.out.println("\n");

					String sql4 = "select no_of_seats from booking where travel_date=to_date('" + date2
							+ "','yyyy-MM-dd') and user_id=" + userId + "";
					// System.out.println(sql4);
					ResultSet seats = connection.createStatement().executeQuery(sql4);
					if (seats.next()) {
						int seats1 = seats.getInt("no_of_seats");
						a = seats1 * amount;
						System.out.println("AMOUNT TO BE PAID=" + a);

						String sql3 = "update booking set amount=" + a + "where travel_date=to_date('" + date2
								+ "','yyyy-MM-dd') and user_id=" + userId + "";
						stmt.executeUpdate(sql3);
					}
					String sql5 = "select no_of_seats from bookingQueue where travel_date=to_date('" + date2
							+ "','yyyy-MM-dd') and user_id=" + userId + "";
					ResultSet seats1 = connection.createStatement().executeQuery(sql5);

					if (seats1.next()) {
						int seats2 = seats1.findColumn("no_of_seats");
						int b = seats2 * amount;
						String sql6 = "update bookingQueue set amount=" + b + "where travel_date=to_date('" + date2
								+ "','yyyy-MM-dd') and user_id=" + userId + "";
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
					Logger.getInstance().info("PNR NUMBER=" + pnr + "\n" + "TRAVEL DATE=" + date1);
				}


			} else {

				throw new DbException("YOUR ACCOUNT IS BLOCKED ");
			}
		}
		return a;

	}

	public void login(String emailid, String password) throws DbException, SQLException {

		
		
		String sql1 = "select email_id,pass from registration where email_id =? and pass =?";
		try (
			Connection connection = TestConnect.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql1);){
			
			stmt.setString(1, emailid);
			stmt.setString(2, password);
			try(
			ResultSet row = stmt.executeQuery();){
			if (row.next()) {
				String emailid1 = row.getString("email_id");
				String password1 = row.getString("pass");

				if (emailid1.equals(emailid) && password1.equals(password)) {
					throw new DbException("LOGGED IN");
				}
			} else {
			throw new DbException("INVALID EMAIL ID OR PASSWORD");
			}
		}
			 catch (Exception e) {
			throw new DbException("UNABLE TO EXECUTE");
		}
		}
	 catch (Exception e1) {
		throw new DbException("ESTABLISH CONNECTION");

		} 
	}
}
