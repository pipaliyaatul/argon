package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import dao.CustomerDAO;
import model.CustomerBean;

//Code in Progress with PRANAV
public class CustomerService {

	public ArrayList<CustomerBean> getAllCustomer() {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getAllCustomer();
	}
	
	
	public int insertCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		CustomerDAO custDao = new CustomerDAO();
		return custDao.insertCustomer(customer);
	}
	
	public CustomerBean getCustomerById(int id){
		CustomerDAO custDao = new CustomerDAO();
		return custDao.getCustomerById(id);
	}


	public int updateCustomer(CustomerBean customer,int id) {
		CustomerDAO custDao = new CustomerDAO();
		return custDao.updateCustomer(customer,id);
	}
	
	public ArrayList<CustomerBean> getAllUnassignedRetailer() {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getAllUnassignedRetailer();
	}
	
	public ArrayList<CustomerBean> getAllUnassignedOperator() {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getAllUnassignedOperator();
	}

	public ArrayList<CustomerBean> getAllCustomer(int op_id) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getAllCustomer(op_id);
	}


	public int insertCustomerBySelf(CustomerBean customer) {
		// TODO Auto-generated method stub
		CustomerDAO custDao = new CustomerDAO();
		return custDao.insertCustomerBySelf(customer);
	}
	
	public LinkedHashMap<String,Integer> barchart() {
		CustomerDAO custDao = new CustomerDAO();
		return custDao.barchart();
	}
}
