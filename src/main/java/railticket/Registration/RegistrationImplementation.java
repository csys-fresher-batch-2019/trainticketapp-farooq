package railticket.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import railticket.TestConnect;
import railticket.DAO.RegistrationDAO;

public class RegistrationImplementation implements RegistrationDAO {

	

	public void changephonenum(int userid, long phonenumber) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select user_id from registration where user_id='" + userid + "'";

		ResultSet row1 = stmt.executeQuery(query);

		if (row1.next()) {

			int userid1 = row1.getInt("user_id");

			if (userid == userid1) {

				String query1 = "update registration set phone_num =" + phonenumber + "where user_id='" + userid + "'";
				stmt.executeUpdate(query1);
			}
		} else {
			throw new Exception("INVALID");

		}

	}

	public ArrayList<Register> getAllUserDetails() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select * from registration";

		ResultSet row = stmt.executeQuery(query);

		ArrayList<Register> task = new ArrayList<Register>();

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

		return task;
	}

	public void deleteUser(String emailid) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String sql = "select email_id from registration where email_id ='" + emailid + "'";

		ResultSet row1 = stmt.executeQuery(sql);

		if (row1.next()) {

			String emailid1 = row1.getString("email_id");

			if (emailid.equals(emailid1)) {
				String sql1 = "delete registration where email_id='" + emailid + "'";
				int row = stmt.executeUpdate(sql1);
				System.out.println(row);

			}

		} else {
			throw new Exception("INVALID");
		}
	}

	public void getUserByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select * from registration where city_name='" + city + "'";

		ResultSet row1 = stmt.executeQuery(query);

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
			System.out.println(task);

		} else {
			throw new Exception("INVALID");
		}

	}

	public String getUserPassword1(String emailid) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select pass from registration where email_id='" + emailid + "'";

		ResultSet row = stmt.executeQuery(query);
		String password = null;

		if (row.next()) {
			password = row.getString("pass");

		}
		return password;

	}

	public List<Register> getUserDetails(int userid) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();
		Statement stmt = connection.createStatement();

		String sql = "select * from registration where user_id='" + userid + "'";

		ResultSet row = stmt.executeQuery(sql);

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

				System.out.println("VALID");

			}
		} else {
			throw new Exception("INVALID");
		}
		return task;

	}

	public void changePassword(String emailid, String pass) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select email_id from registration where email_id='" + emailid + "'";

		ResultSet row1 = stmt.executeQuery(query);
		if (row1.next()) {

			String emailid1 = row1.getString("email_id");

			if (emailid.equals(emailid1)) {

				String query1 = "update registration set pass='" + pass + "'where email_id='" + emailid1 + "'";

				int row = stmt.executeUpdate(query1);
				System.out.println(row);

			}
		} else {
			throw new Exception("INCORRECT");
		}

	}

	public static void save(Register obj) throws Exception {
		Connection connection = TestConnect.getConnection();

		String sql = "insert into registration values(?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(2, obj.getUsername());
		ps.setInt(1, obj.getUserid());
		ps.setString(4, obj.getEmailid());
		ps.setString(3, obj.getPassword());
		ps.setLong(5, obj.getPhonenum());
		ps.setString(6, obj.getGender());
		ps.setString(8, obj.getCityname());
		ps.setDate(7, obj.getDob());

		ps.executeUpdate();

	}

	public void registrationInsert(String username, String password, String emailid, long phonenumber, String gender,
			LocalDate dob, String cityname) throws Exception {
		// TODO Auto-generated method stub\

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String sql = "insert into registration(user_id,user_name,pass,email_id,phone_num,gender,dob,city_name) values(user_id_seq.nextval,'" + username + "','" + password + "','"
				+ emailid + "'," + phonenumber + ",'" + gender + "',to_date('" + dob + "','yyyy-MM-dd'),'" + cityname
				+ "')";
		System.out.println(sql);
		String sql1 = "select user_id from registration where email_id='" + emailid + "'";
		stmt.executeUpdate(sql);

		ResultSet row1 = stmt.executeQuery(sql1);
		if (row1.next()) {
			System.out.println("NOTE DOWN THE USER_ID FOR BOOKING");
			String user_id = row1.getString("user_id");
			System.out.println("USER-ID=" + user_id);
		}

	}

	public void blockUser(int userid, int status) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String sql = "update registration set blocklist = '" + status + "'where user_id='"+userid+"'";
		System.out.println(sql);

		stmt.executeUpdate(sql);
		
		

	}

	
	
}
