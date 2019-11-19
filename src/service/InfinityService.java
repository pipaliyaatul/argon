package service;

import dao.LoginDAO;
import model.LoginBean;

public class InfinityService {

	public LoginBean validateLogin(LoginBean user) {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.validateLogin(user);
	}

	public LoginBean registerUser(LoginBean login) {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.registerUser(login);
	}

	public boolean deleteUser(LoginBean user) {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.deleteUser(user);
	}

	public boolean changePassword(LoginBean user) {

		return (new LoginDAO().changePassword(user));
	}

	public String getOperatorForCustomer(LoginBean user) {
		// TODO Auto-generated method stub
		return (new LoginDAO().getOperatorForCustomer(user));
	}

	public String getRetailerForCustomer(LoginBean user) {
		// TODO Auto-generated method stub
		return (new LoginDAO().getRetailerForCustomer(user));
	}

}
