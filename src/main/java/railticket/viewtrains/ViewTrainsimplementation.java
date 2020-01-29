package railticket.viewtrains;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import railticket.TestConnect;
import railticket.DAO.ListTrainDAO;

public class ViewTrainsimplementation implements ListTrainDAO {

	
	public ArrayList<ListTrain> getTrainsByArrivalTime() throws Exception {

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query1 = "select train_num,train_name, to_char(arr_time,'hh24:mi:ss')as ar,route,boarding_station,destination_station,dept_time,status from viewtrain order by arr_time desc";

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		ResultSet row = stmt.executeQuery(query1);

		while (row.next()) {
			ListTrain obj = new ListTrain();

			obj.trainnumber = row.getInt("train_num");
			obj.trainname = row.getString("train_name");
			obj.Boardingstation = row.getString("boarding_station");
			obj.destinationstation = row.getString("destination_station");
			obj.arrivaltime = row.getString("ar");
			obj.depaturetime = row.getString("dept_time");
			obj.route = row.getString("route");
			obj.status = row.getString("status");

			task.add(obj);
		}
		return task;
		// TODO Auto-generated method stub

	}

	public ArrayList<ListTrain> getTrainsByDeptTime() throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select train_num,train_name, to_char(dept_time,'hh24:mi:ss') as dept,route,boarding_station,destination_station,arr_time,status from viewtrain order by arr_time asc";

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		ResultSet row = stmt.executeQuery(query);

		while (row.next()) {
			ListTrain obj = new ListTrain();

			obj.trainnumber = row.getInt("train_num");
			obj.trainname = row.getString("train_name");
			obj.Boardingstation = row.getString("boarding_station");
			obj.destinationstation = row.getString("destination_station");
			obj.arrivaltime = row.getString("arr_time");
			obj.depaturetime = row.getString("dept");
			obj.route = row.getString("route");
			obj.status = row.getString("status");

			task.add(obj);
		}
		return task;
	}

	public ArrayList<ListTrain> getTrainDetailsByname(String trainname) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		String query = "select * from viewtrain where train_name LIKE '%" + trainname + "%'";

		ResultSet row = stmt.executeQuery(query);
		if (row.next()) {

			ListTrain obj = new ListTrain();

			obj.trainnumber = row.getInt("train_num");
			obj.trainname = row.getString("train_name");
			obj.Boardingstation = row.getString("boarding_station");
			obj.destinationstation = row.getString("destination_station");
			obj.arrivaltime = row.getString("arr_time");
			obj.depaturetime = row.getString("dept_time");
			obj.route = row.getString("route");
			obj.status = row.getString("status");

			task.add(obj);
		} else {
			throw new Exception("INVALID TRAIN NAME");
		}
		return task;
	}

	public ArrayList<ListTrain> getTrainDetailsByTrainNumber(int trainnum) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		String query = "select * from viewtrain where train_num=" + trainnum + "";

		ResultSet row = stmt.executeQuery(query);

		if (row.next()) {

			ListTrain obj = new ListTrain();

			obj.trainnumber = row.getInt("train_num");
			obj.trainname = row.getString("train_name");
			obj.Boardingstation = row.getString("boarding_station");
			obj.destinationstation = row.getString("destination_station");
			obj.arrivaltime = row.getString("arr_time");
			obj.depaturetime = row.getString("dept_time");
			obj.route = row.getString("route");
			obj.status = row.getString("status");

			task.add(obj);
		} else {
			throw new Exception("INVALID TRAIN NAME");
		}

		return task;

	}

	public void insertnewTrain(ListTrain lt) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String sql = "insert into viewtrain values(" + lt.trainnumber + ",'" + lt.trainname + "','" + lt.Boardingstation
				+ "','" + lt.destinationstation + "',to_timestamp('" + lt.arrivaltime + "','HH:MI:SS'),to_timestamp('"
				+ lt.depaturetime + "','HH:MI:SS'),'" + lt.route + "','" + lt.status + "'," + lt.amount + ")";

		stmt.executeUpdate(sql);
		System.out.println(sql);
	}

	public ArrayList<ListTrain> getAllTrainsDetails() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();

		String query = "select * from viewtrain";
		System.out.println(query);

		ResultSet row = stmt.executeQuery(query);

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		while (row.next()) {
			ListTrain obj = new ListTrain();
			obj.trainnumber = row.getInt("train_num");
			obj.trainname = row.getString("train_name");
			obj.Boardingstation = row.getString("boarding_station");
			obj.destinationstation = row.getString("destination_station");
			obj.arrivaltime = row.getString("arr_time");
			obj.depaturetime = row.getString("dept_time");
			obj.route = row.getString("route");
			obj.status = row.getString("status");

			task.add(obj);
		}

		return task;
	}

}
