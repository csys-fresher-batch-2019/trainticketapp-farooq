package railticket.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import railticket.exception.DbException;
import railticket.viewtrains.ListTrain;

public interface ListTrainDAO {

	
	public ArrayList<ListTrain> getAllTrainsDetails() throws DbException ;
	
	public ArrayList<ListTrain> getTrainsByArrivalTime()throws DbException;
	
	public ArrayList<ListTrain> getTrainsByDeptTime()throws DbException;
	
	public ArrayList<ListTrain> getTrainDetailsByname(String name)throws DbException;
	
	public void insertnewTrain(ListTrain lt)throws DbException;
	
	public ArrayList<ListTrain> getTrainDetails(String boardingStation,String destinationStation,LocalDate date) throws DbException;
	
	
}