package railticket.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import railticket.TestConnect;
import railticket.dao.Logger;
import railticket.exception.DbException;

public class RegistrationImplementation implements railticket.dao.RegistrationDAO {

	public void changephonenum(int userid, long phonenumber) throws DbException {

		String query = "select user_id from registration where user_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {
			stmt.setInt(1, userid);
			try (ResultSet row1 = stmt.executeQuery();) {

				if (row1.next()) {

					int userid1 = row1.getInt("user_id");

					if (userid == userid1) {

						String query1 = "update registration set phone_num =? where user_id=?";
						
					try(
						PreparedStatement stmt1 = connection.prepareStatement(query1);){

						stmt1.setLong(1, phonenumber);
						stmt1.setInt(2, userid);
						stmt1.executeUpdate();
					} catch(Exception e) {
						throw new Exception("INVALID USER");

					}

				}
			}} catch (Exception e) {
				throw new DbException("UNABLE TO PROCESS");
			}

		} catch (Exception e1) {
			throw new DbException("UNABLE TO CONNECT");
		}
	}

	public ArrayList<Register> getAllUserDetails() throws DbException {
		ArrayList<Register> task = new ArrayList<Register>();
		String query = "select * from registration";
		try (Connection connection = TestConnect.getConnection(); Statement stmt = connection.createStatement();) {

			try (

					ResultSet row = stmt.executeQuery(query);) {

				while (row.next()) {
					Register obj = new Register();
					obj.setUsername(row.getString("user_name"));
					obj.setUserid(row.getInt("user_id"));
					obj.setEmailid(row.getString("email_id"));
					obj.setPhonenum(row.getLong("phone_num"));
					obj.setPassword(row.getString("pass"));
					obj.setGender(row.getString("gender"));
					obj.setDob(row.getDate("dob"));
					obj.setCityname(row.getString("city_name"));

					task.add(obj);

				}

			} catch (Exception e) {
				throw new DbException("ESTABLISH CONNECTION");
			}
		} catch (SQLException e1) {
			throw new DbException("UNABLE TO PROCESS QUERY");

		} catch (Exception e1) {
			throw new DbException("UNABLE TO PROCESS");
		}
		return task;

	}

	public void deleteUser(String emailid) throws DbException, Exception {
		String sql = "select email_id from registration where email_id =?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setString(1, emailid);
			try (ResultSet row1 = stmt.executeQuery();) {

				if (row1.next()) {

					String emailid1 = row1.getString("email_id");

					if (emailid.equals(emailid1)) {
						String sql1 = "delete registration where email_id=?";
						
						try(
						PreparedStatement stmt1 = connection.prepareStatement(sql1);){
						stmt1.executeUpdate(sql1);

					}

				 catch(Exception e) {
					throw new Exception("INVALID");
				}
					}}} catch (Exception e) {
				throw new DbException("ESTABLISH CONNECTION");
			}}
	}

	public void getUserByCity(String city) throws DbException {

		String query = "select * from registration where city_name=?";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {

			stmt.setString(1, city);
			try (ResultSet row1 = stmt.executeQuery();) {

				ArrayList<Register> task = new ArrayList<Register>();
				if (row1.next()) {

					String city1 = row1.getString("city_name");

					if (city.equals(city1)) {

						Register obj = new Register();

						obj.setUsername(row1.getString("user_name"));
						obj.setUserid(row1.getInt("user_id"));
						obj.setEmailid(row1.getString("email_id"));
						obj.setPhonenum(row1.getLong("phone_num"));
						obj.setPassword(row1.getString("pass"));
						obj.setGender(row1.getString("gender"));
						obj.setDob(row1.getDate("dob"));
						obj.setCityname(row1.getString("city_name"));

						task.add(obj);
					}
					Logger.getInstance().info(task);

				} else {
					throw new Exception("INVALID CITY");
				}
			} catch (Exception e) {
				throw new DbException("ESTABLISH CONNECTION");
			}
		} catch (SQLException e1) {
			throw new DbException("UNABLE TO PROCESS SQL QUERY");
		} catch (Exception e1) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}

	public String getUserPassword1(String emailid) throws DbException {

		String query = "select pass from registration where email_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {
			stmt.setString(1, emailid);

			try (ResultSet row = stmt.executeQuery();) {
				String password = null;

				if (row.next()) {
					password = row.getString("pass");

				} else {
					throw new DbException("ESTABLISH CONNECTION");
				}
				return password;
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO PROCESS SQL QUERY");
		} catch (Exception e) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}

	public List<Register> getUserDetails(int userid) throws DbException {
		String sql = "select * from registration where user_id=?";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);) {

			stmt.setInt(1, userid);
			try (

					ResultSet row = stmt.executeQuery();) {

				ArrayList<Register> task = new ArrayList<Register>();
				if (row.next()) {
					Register p1 = new Register();

					p1.setUsername(row.getString("user_name"));
					p1.setUserid(row.getInt("user_id"));
					p1.setEmailid(row.getString("email_id"));
					p1.setPhonenum(row.getLong("phone_num"));
					p1.setPassword(row.getString("pass"));
					p1.setGender(row.getString("gender"));
					p1.setDob(row.getDate("dob"));
					p1.setCityname(row.getString("city_name"));

					task.add(p1);

					int userid1 = row.getInt("user_id");
					if (userid == (userid1)) {

						throw new DbException("VALID");

					}
				} else {
					throw new Exception("INVALID");
				}
				return task;
			}catch (Exception e) {
throw new DbException("ESTABLISH CONNECTION");
			}
		} catch (SQLException e) {
			throw new DbException("INVALID QUERY");
		} catch (Exception e) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}

	public void changePassword(String emailid, String pass) throws DbException {
		String query = "select email_id from registration where email_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {

			stmt.setString(1, emailid);
			try (ResultSet row1 = stmt.executeQuery();) {

				if (row1.next()) {

					String emailid1 = row1.getString("email_id");

					if (emailid.equals(emailid1)) {

						String query1 = "update registration set pass='" + pass + "'where email_id='" + emailid1 + "'";

						int row = stmt.executeUpdate(query1);
						System.out.println(row);

					}
				} else {
					throw new Exception("INCORRECT EMAILID");
				}
			} catch (Exception e) {
			throw new DbException("ESTABLISH CONNECTION");
			}
		} catch (SQLException e1) {
			throw new DbException("INVALID QUERY");

		} catch (Exception e1) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}

	public static void save(Register obj) throws DbException {
		
		String sql = "insert into registration values(?,?,?,?,?,?,?,?)";
		try(Connection connection = TestConnect.getConnection();		
		PreparedStatement ps = connection.prepareStatement(sql);){
			
		ps.setString(2, obj.getUsername());
		ps.setInt(1, obj.getUserid());
		ps.setString(4, obj.getEmailid());
		ps.setString(3, obj.getPassword());
		ps.setLong(5, obj.getPhonenum());
		ps.setString(6, obj.getGender());
		ps.setString(8, obj.getCityname());
		ps.setDate(7, obj.getDob());

		ps.executeUpdate();

	} catch (SQLException e) {
		
	} catch (Exception e) {
		throw new DbException("UNABLE TO PROCESS");
	}}

	public void registrationInsert(String username, String password, String emailid, long phonenumber, String gender,
			LocalDate dob, String cityname) throws DbException {

		try (
			Connection connection = TestConnect.getConnection();

			Statement stmt = connection.createStatement();){

			String sql = "insert into registration(user_id,user_name,pass,email_id,phone_num,gender,dob,city_name) values(user_id_seq.nextval,'"
					+ username + "','" + password + "','" + emailid + "'," + phonenumber + ",'" + gender + "',to_date('"
					+ dob + "','yyyy-MM-dd'),'" + cityname + "')";
			System.out.println(sql);
			String sql1 = "select user_id from registration where email_id='" + emailid + "'";
			stmt.executeUpdate(sql);
try(
			ResultSet row1 = stmt.executeQuery(sql1);){
			if (row1.next()) {
				System.out.println("NOTE DOWN THE USER_ID FOR BOOKING");
				String user_id = row1.getString("user_id");
				System.out.println("USER-ID=" + user_id);
			}
		} catch (Exception e) {
throw new DbException("invalid entry");
	}

	}catch(Exception e) {
	throw new DbException("ESTABLISH CONNECTION");	
	}
	}
	public void blockUser(int userid, int status) throws DbException {

		String sql = "update registration set blocklist =? where user_id=?";
		try (
			Connection connection = TestConnect.getConnection();

			PreparedStatement stmt = connection.prepareStatement(sql);){
			stmt.setInt(1, status);
			stmt.setInt(2, userid);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DbException("ESTABLISH CONNECTION");
		}

	}

}
