package service;

import java.util.ArrayList;

import dao.OperatorDAO;
import dao.RetailerDAO;
import model.OperatorBean;
import model.RetailerBean;

public class OperatorService 
{
	public ArrayList<OperatorBean> getAllOperator() {
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.getAllOperator();
	}
	
	public int insertOperator(OperatorBean operator) {
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.insertOperator(operator);
	}

	
	public OperatorBean getOperatorById(OperatorBean operator){
		OperatorDAO operatorDAO = new OperatorDAO();
		operator = operatorDAO.getOperatorByID(operator);
		return operator;
	}
	
	
	public int updateOperator(OperatorBean operator){
		OperatorDAO operatorDAO = new OperatorDAO();
		int result = operatorDAO.updateOperator(operator);
		
		return result;
	}

	public ArrayList<OperatorBean> getAllOperatorAvailable() {
		OperatorDAO opDAO = new OperatorDAO();
		return opDAO.getAllOperatorAvailable();
	}
	
}
