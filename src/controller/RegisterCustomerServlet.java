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
import model.RetailerBean;
import service.CustomerService;
import service.InfinityService;
import service.RetailerService;
import utilities.Info;

/**
 * Servlet implementation class RegisterCustomerServlet
 */
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCustomerServlet() {
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
		CustomerService customerService = new CustomerService();
		HttpSession session = request.getSession();

//		if (role_id == Info.OPERATOR_ROLE_ID) {
//			response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE_DISPLAY_CUSTOMER);
//		} else if(role_id == Info.ADMIN_ROLE_ID){
//			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_DISPLAY_CUSTOMER);
//		}
//		else{
//			String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
//			response.sendRedirect(loginURI);
//		}
		

		
//		System.out.println("in register retailer servlet "+retailerList);
		
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

		if (role_id == Info.OPERATOR_ROLE_ID) {

			RetailerService retailerService = new RetailerService();
			ArrayList<CustomerBean> customerList = customerService.getAllCustomer((Integer)session.getAttribute(Info.SESSION_USER_ID));
			session.setAttribute("customerList", customerList);
			response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE_DISPLAY_CUSTOMER);

		} else if(role_id == Info.ADMIN_ROLE_ID){
			
		
			RetailerService retailerService = new RetailerService();
			ArrayList<CustomerBean> customerList = customerService.getAllCustomer();
			session.setAttribute("customerList", customerList);
			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_DISPLAY_CUSTOMER);
		}
		else{
			String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
			response.sendRedirect(loginURI);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		int user_id = (Integer) session.getAttribute(Info.SESSION_USER_ID);
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

		if (role_id == 1) {
			customer.setOperator_id(user_id);
		} else {
			customer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
		}
		//customer.setRetailer_id(Info.DEFAULT_RETAILER_ID);

		// customer.setOperator_id(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_OP_ID)));
		customer.setRetailer_id(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_RET_ID)));
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
		
		CustomerService custServ = new CustomerService();

		int code = custServ.insertCustomer(customer);

		if(code == 0) session.setAttribute("msg", "Please try again!");
		else session.setAttribute("msg", "Customer registered successfully!");
		
		role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		if(role_id == Info.ADMIN_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
		}
		else if(role_id == Info.OPERATOR_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.OPERATOR_MESSAGE_PAGE);
		}

	}

}
