package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.CustomerDAO;
import dao.RetailerDAO;
import model.CustomerBean;
import model.RetailerBean;

public class RetailerService {

	public int registerRetailer(RetailerBean retailer) {
		// TODO Auto-generated method stub
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.registerRetailer(retailer);
	}

	public ArrayList<RetailerBean> getAllRetailer() {
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.getAllRetailer();
	}
	
	public RetailerBean getRetailerDetails(RetailerBean retailer) {
		// TODO Auto-generated method stub
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.getRetailerById(retailer);
	}

	public int updateRetailer(RetailerBean retailer) {
		// TODO Auto-generated method stub
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.updateRetailer(retailer);
	}

	public ArrayList<RetailerBean> getAllRetailer(Object retailer_id) {
		// TODO Auto-generated method stub
		RetailerDAO retailerDAO = new RetailerDAO();

		return retailerDAO.getAllRetailer(retailer_id);
	}
	
	public ArrayList<RetailerBean> getAllRetailerAvailable() {
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.getAllRetailerAvailable();

		// TODO Auto-generated method stub }
	}
	
	public ArrayList<RetailerBean> getAllRetailerAvailableByOperator(Object retailer_id) {
		// TODO Auto-generated method stub
		//pranav edited this last
		RetailerDAO retailerDAO = new RetailerDAO();

		return retailerDAO.getAllRetailerAvailableByOperator(retailer_id);
		
	}
	
	public HashMap<String, Integer> piechart() {
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.piechart();
	}

}
