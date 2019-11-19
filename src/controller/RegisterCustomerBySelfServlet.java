package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;
import model.LoginBean;
import service.CustomerService;
import service.InfinityService;
import utilities.Info;

/**
 * Servlet implementation class RegisterCustomerBySelfServlet
 */
public class RegisterCustomerBySelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCustomerBySelfServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Just entered");
		// TODO Auto-generated method stub
		// Code in progress by Pranav
		// TODO Auto-generated method stub
		// Code in progress by Pranav
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// hardcoded data for testing
		// CustomerBean customer = new
		// CustomerBean(1,1,1,"servTest","servTest","test@test.com",94989281,"test
		// street",
		// "test home",95126,"testcity","testState",getCurrentTimeStamp());

		CustomerBean customer = new CustomerBean();
		LoginBean login = new LoginBean();

		login.setUser_name(request.getParameter(Info.CUSTOMER_TABLE_EMAIL));
		login.setUser_password(Info.DEFAULT_PASSWORD);
		login.setUser_role_Id(Info.CUSTOMER_ROLE_ID);

		InfinityService is = new InfinityService();

		login = is.registerUser(login);
		// For the form date
		customer.setCustomer_id(login.getUser_Id());

		HttpSession session = request.getSession();
		// valid for 30 mins

		// customer.setRetailer_id(Info.DEFAULT_RETAILER_ID);

		// customer.setOperator_id(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_OP_ID)));
		customer.setFirst_name(request.getParameter(Info.CUSTOMER_TABLE_FNAME));
		customer.setLast_name(request.getParameter(Info.CUSTOMER_TABLE_LNAME));
		customer.setEmail_id(request.getParameter(Info.CUSTOMER_TABLE_EMAIL));
		customer.setPhone(Long.parseLong(request.getParameter(Info.CUSTOMER_TABLE_PHONE)));
		customer.setAddress1(request.getParameter(Info.CUSTOMER_TABLE_ADD1));
		customer.setAddress2(request.getParameter(Info.CUSTOMER_TABLE_ADD2));
		customer.setZipcode(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_ZIP)));
		customer.setCity(request.getParameter(Info.CUSTOMER_TABLE_CITY));
		customer.setState(request.getParameter(Info.CUSTOMER_TABLE_STATE));
		customer.setCreated_on(Info.getCurrentTimeStamp());
		customer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
		customer.setRetailer_id(Info.DEFAULT_RETAILER_ID);
		System.out.println("after set");
		CustomerService custServ = new CustomerService();

		int code = custServ.insertCustomerBySelf(customer);
		// System.out.println("after insertdao");
		if (code == 1) {
			response.sendRedirect(request.getContextPath() + "/JSPFrontPages/Customer/RedirectAfterLogin.jsp");
		}

//		else {
//			String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
//			response.sendRedirect(loginURI);
//		}
		// if(code == 0) session.setAttribute("msg", "Please try again!");

		// else session.setAttribute("msg", "Customer registered
		// successfully!");

		/*
		 * if(role_id == Info.ADMIN_ROLE_ID){
		 * response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE); }
		 * else if(role_id == Info.OPERATOR_ROLE_ID){
		 * response.sendRedirect(request.getContextPath()+Info.
		 * OPERATOR_MESSAGE_PAGE); }
		 */

		// String loginURI = request.getContextPath() +
		// "/JSPFrontPages/Login.jsp";
		// response.sendRedirect(loginURI);

	}

}
