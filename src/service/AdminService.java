package service;

import dao.CustomerDAO;
import dao.RetailerDAO;

public class AdminService {

	public boolean updateAssignedRetailer(String customer_id,String retailer_id) {
		// TODO Auto-generated method stub
		CustomerDAO cDAO = new CustomerDAO();
		return cDAO.updateAssignedRetailer((Integer.parseInt(customer_id)),Integer.parseInt(retailer_id));
	}

	public boolean updateAssignedOperator(String customer_id, String operator_id) {
		// TODO Auto-generated method stub
		CustomerDAO cDAO = new CustomerDAO();
		return cDAO.updateAssignedOperator((Integer.parseInt(customer_id)),Integer.parseInt(operator_id));
	}

}
