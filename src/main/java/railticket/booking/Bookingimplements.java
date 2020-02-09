package railticket.booking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import railticket.TestConnect;
import railticket.dao.Logger;
import railticket.exception.DbException;
import railticket.exception.ErrorMessages;

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
					String status=row.getString("curr_status");
					logger.info(status);
				}
				else {
					logger.info("NO DATA");
				}

			} catch (SQLException e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}
		} catch (Exception e) {
			throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
		}
	}

	public void getPassengernames(int noOfSeats) {

	}

	public int bookSeats(int trainnumber, int userId, String boarding, String destination, int noOfSeats,
			LocalDate date) throws DbException, SQLException {
		
		int a = 0;
		
	try(	Connection connection = TestConnect.getConnection();
			Statement stmt1 = connection.createStatement()	){
	
		String sql = "select blocklist from registration where user_id="+userId+"" ;

		
		try(ResultSet row =  stmt1.executeQuery(sql);){
		
		if (row.next()) {
			int status = row.getInt("blocklist");
		
			if (status == 0) {
				System.out.println(trainnumber +"-" + userId + "-" + boarding +"-" + destination + "-" + date + "-" + noOfSeats);
		try(
				CallableStatement stmt = connection.prepareCall("{call PR_booking_status(?,?,?,?,?,?)}");){
				stmt.setInt(1, trainnumber);
				stmt.setInt(2, userId);
				stmt.setString(3, boarding);
				stmt.setString(4, destination);
				java.sql.Date date2 = java.sql.Date.valueOf(date);
				stmt.setDate(6, date2);
				stmt.setInt(5, noOfSeats);
				
				stmt.executeQuery();
				
				String sql2 = "select amount from viewtrain where train_num='" + trainnumber + "'";
				try(
				ResultSet row3 = connection.createStatement().executeQuery(sql2);){
				if (row3.next()) {
					int amount = row3.getInt("amount");
					System.out.println("BOOKING DETAILS");
					System.out.println("\n");

					String sql4 = "select no_of_seats from booking where travel_date=to_date('" + date2
							+ "','yyyy-MM-dd') and user_id=" + userId + "";
					try(
					ResultSet seats = connection.createStatement().executeQuery(sql4);){
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
					try(
					ResultSet seats1 = connection.createStatement().executeQuery(sql5);){

					if (seats1.next()) {
						int seats2 = seats1.findColumn("no_of_seats");
						int b = seats2 * amount;
						String sql6 = "update bookingQueue set amount=" + b + "where travel_date=to_date('" + date2
								+ "','yyyy-MM-dd') and user_id=" + userId + "";
						stmt.executeUpdate(sql6);
						System.out.println("\n");
					}
				}catch(Exception e) {
					throw new DbException(ErrorMessages.INVALID_SQLQUERY);
				}
					}catch(Exception e) {
					throw new DbException(ErrorMessages.INVALID_SQLQUERY);
				}

				String sql1 = "select pnr_num,travel_date from booking where travel_date=to_date('" + date
						+ "','yyyy-MM-dd')";

				try(
				ResultSet row1 = connection.createStatement().executeQuery(sql1);){
				while (row1.next()) {
					int pnr = row1.getInt("pnr_num");
					Date date1 = row1.getDate("travel_date");
					Logger.getInstance().info("PNR NUMBER=" + pnr + "\n" + "TRAVEL DATE=" + date1);
				}

			}catch(Exception e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}
				}}catch(Exception e) {
					throw new DbException(ErrorMessages.INVALID_SQLQUERY);
				}
				} catch(Exception e) {
				throw new DbException(ErrorMessages.ALL_VARIABLES_NOT_BOUND);
			}
		}else {

				throw new DbException("YOUR ACCOUNT IS BLOCKED ");
			}
		}
		
	}catch(DbException e) {
		throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
	}
		}catch(DbException e1) {
		throw new DbException(ErrorMessages.INVALID_SQLQUERY);
	} catch (Exception e2) {
			
		}
	return a;
	
	}

	public boolean login(int userid, String password) throws DbException {

		String sql1 = "select user_id,pass from registration where user_id =? and pass =?";
Boolean result = false;
	try(	Connection connection = TestConnect.getConnection();
		PreparedStatement stmt = connection.prepareStatement(sql1);){
		

		stmt.setInt(1, userid);
		stmt.setString(2, password);
try(
		ResultSet row = stmt.executeQuery();){
		if (row.next()) {
			int userid1 = row.getInt("user_id");
			String password1 = row.getString("pass");

			if (userid1==userid && password1.equals(password)) {
				logger.info("LOGGED IN");
				result=true;
			}
		} else {
			logger.info("INVALID EMAIL ID OR PASSWORD");
		}
	}catch(Exception e) {
		throw new DbException(ErrorMessages.INVALID_SQLQUERY);
	}
	}catch (SQLException e) {
		throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
	} catch (Exception e1) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
	}
	return result;
	}
}
