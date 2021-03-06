package railticket.viewtrains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import railticket.TestConnect;
import railticket.dao.ListTrainDAO;
import railticket.dao.Logger;
import railticket.exception.DbException;
import railticket.exception.ErrorMessages;

public class ViewTrainsimplementation implements ListTrainDAO {

	public ArrayList<ListTrain> getTrainsByArrivalTime() throws DbException {

		try(
		
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();){

		String query1 = "select train_num,train_name, to_char(arr_time,'hh24:mi:ss')as ar,route,boarding_station,destination_station,dept_time,status from viewtrain order by arr_time desc";

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
try(
		ResultSet row = stmt.executeQuery(query1);){

		while (row.next()) {
			ListTrain obj = new ListTrain();

			listall(row, obj);

			task.add(obj);
		}
		return task;

	}catch(Exception e) {
		throw new DbException(ErrorMessages.INVALID_DATA);
	}

}catch(Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	}
	}
	private void listall(ResultSet row, ListTrain obj) throws SQLException {
		obj.setTrainnumber(row.getInt("train_num"));
		obj.setTrainname(row.getString("train_name"));
		obj.setBoardingstation(row.getString("boarding_station"));
		obj.setDestinationstation(row.getString("destination_station"));
		obj.setArrivaltime(row.getString("arr_time"));
		obj.setDepaturetime(row.getString("dept_time"));
		obj.setRoute(row.getString("route"));
		obj.setStatus(row.getString("status"));
	}

	public ArrayList<ListTrain> getTrainsByDeptTime() throws DbException {
try(
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();){

		String query = "select train_num,train_name, to_char(dept_time,'hh24:mi:ss') as dept,route,boarding_station,destination_station,arr_time,status from viewtrain order by arr_time asc";

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
try(
		ResultSet row = stmt.executeQuery(query);){

		while (row.next()) {
			ListTrain obj = new ListTrain();

			listall(row, obj);

			task.add(obj);
		}
		return task;
	}catch(Exception e) {
		throw new DbException(ErrorMessages.INVALID_DATA);
	}

}catch(Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	}
	}

	public ArrayList<ListTrain> getTrainDetailsByname(String trainname) throws DbException {

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
		String query = "select * from viewtrain where train_name LIKE '% ? %'";
		try(
		Connection connection = TestConnect.getConnection();

		PreparedStatement stmt = connection.prepareStatement(query);){

stmt.setString(1, trainname);
		
try(
		ResultSet row = stmt.executeQuery();){
		if (row.next()) {

			ListTrain obj = new ListTrain();

			listall(row, obj);

			task.add(obj);
		} else {
			Logger.getInstance().info("INVALID TRAIN NAME");
		}
	}} catch (SQLException e) {
throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	} catch (Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
	}		return task;
}

	public ArrayList<ListTrain> getTrainDetailsByTrainNumber(int trainnum) throws DbException {
		
		String query = "select * from viewtrain where train_num=?";
		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
		try(
		Connection connection = TestConnect.getConnection();

		PreparedStatement stmt = connection.prepareStatement(query)){

		stmt.setInt(1, trainnum);

		try(

		ResultSet row = stmt.executeQuery();){

		if (row.next()) {

			ListTrain obj = new ListTrain();

			listall(row, obj);

			task.add(obj);
		} 
		} catch (Exception e) {
			throw new DbException(ErrorMessages.INVALID_DATA);
		} 
		} catch (SQLException e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		} 
		return task;
	}
	

	public void insertnewTrain(ListTrain lt) throws DbException {
		
		try(
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();){

		String sql = "insert into viewtrain values(" + lt.getTrainnumber() + ",'" + lt.getTrainname() + "','"
				+ lt.getBoardingstation() + "','" + lt.getDestinationstation() + "',to_timestamp('"
				+ lt.getArrivaltime() + "','HH:MI:SS'),to_timestamp('" + lt.getDepaturetime() + "','HH:MI:SS'),'"
				+ lt.getRoute() + "','" + lt.getStatus() + "'," + lt.getAmount() + ")";

			stmt.executeUpdate(sql);
			}catch(Exception e) {
				throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
			}
	}

	public ArrayList<ListTrain> getAllTrainsDetails() throws DbException {
		try(
		Connection connection = TestConnect.getConnection();

		Statement stmt = connection.createStatement();){

		String query = "select * from viewtrain";
		System.out.println(query);
try(
		ResultSet row = stmt.executeQuery(query);){

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();

		while (row.next()) {
			ListTrain obj = new ListTrain();
			listall(row, obj);

			task.add(obj);
		}

		return task;
		} catch (Exception e) {
			throw new DbException(ErrorMessages.INVALID_DATA);
		} 
} catch (Exception e) {
	throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
} 
	}

	public ArrayList<ListTrain> getTrainDetails(String boardingStation, String destinationStation, LocalDate traveldate)
			throws DbException {
		String sql = "select * from viewtrain where Boarding_station=? and destination_station=? and traveldate=?";
		try (
		Connection connection = TestConnect.getConnection();


		PreparedStatement stmt = connection.prepareStatement(sql);){
		System.out.println(toString());
		stmt.setString(2, destinationStation);
		stmt.setString(1, boardingStation);
		java.sql.Date date1 = java.sql.Date.valueOf(traveldate);
		stmt.setDate(3, date1);

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
	try(
		ResultSet rs = stmt.executeQuery();){
		while (rs.next()) {
			ListTrain obj = new ListTrain();

			listall(rs, obj);

			obj.setDate(traveldate);
			obj.setAmount(rs.getInt("amount"));
			task.add(obj);
		}
		return task;
		} catch (Exception e) {
			throw new DbException(ErrorMessages.INVALID_DATA);
		} 
	} catch (Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	} 

	}
		}


