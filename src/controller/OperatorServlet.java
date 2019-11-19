package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;
import model.LoginBean;
import model.OperatorBean;
import service.CustomerService;
import service.InfinityService;
import service.OperatorService;
import utilities.Info;

/**
 * Servlet implementation class OperatorServlet
 */
public class OperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OperatorBean operator = new OperatorBean();
		HttpSession session = request.getSession();

		System.out.println("In Operator register " +request.getParameter(Info.OPERATOR_TABLE_SEND));
//		customer.setOperator_id(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_OP_ID)));
//		customer.setRetailer_id(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_RET_ID)));
		operator.setFirst_name(request.getParameter(Info.OPERATOR_TABLE_FIRST_NAME));
		operator.setLast_name(request.getParameter(Info.OPERATOR_TABLE_LAST_NAME));
		operator.setEmail_id(request.getParameter(Info.OPERATOR_TABLE_EMAIL));
		operator.setPhone(Long.parseLong(request.getParameter(Info.OPERATOR_TABLE_PHONE)));
		operator.setShift_start_time(request.getParameter(Info.OPERATOR_TABLE_SSTART));
		operator.setShift_end_time(request.getParameter(Info.OPERATOR_TABLE_SEND));
		operator.setCustomer_limit(Integer.parseInt(request.getParameter(Info.OPERATOR_TABLE_CLIMIT)));
		operator.setCreated_on(Info.getCurrentTimeStamp());
		operator.setTotal_active_customer(Integer.parseInt(request.getParameter(Info.OPERATOR_TABLE_TOTAL_CUST)));

		OperatorService operServ = new OperatorService();

		int code = operServ.insertOperator(operator);

		

		if(code == 0) session.setAttribute("msg", "Please try again!");
		else session.setAttribute("msg", "Operator inserted successfully!");
		
		response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
	}
	

}
