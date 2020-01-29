package railticket.DAO;

import java.util.ArrayList;

import railticket.viewtrains.ListTrain;

public interface ListTrainDAO {

	
	public ArrayList<ListTrain> getAllTrainsDetails() throws Exception ;
	
	public ArrayList<ListTrain> getTrainsByArrivalTime()throws Exception;
	
	public ArrayList<ListTrain> getTrainsByDeptTime()throws Exception;
	
	public ArrayList<ListTrain> getTrainDetailsByname(String name)throws Exception;
	
	public void insertnewTrain(ListTrain lt)throws Exception;
	
	
	
}