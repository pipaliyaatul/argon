package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;
import service.CustomerService;
import utilities.Info;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerService customerService = new CustomerService();
		HttpSession session = request.getSession();
		CustomerBean customer = customerService.getCustomerById(id);
		session.setAttribute("customer", customer);
		
		
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		System.out.println("user role id IN: "+role_id);
		if (role_id == Info.OPERATOR_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE_UPDATE_CUSTOMER);

		} else if (role_id == Info.ADMIN_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_UPDATE_CUSTOMER);
			
		} else {
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
		
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("id"));
		CustomerBean customer = new CustomerBean();

		// For the form date
		customer.setCustomer_id(id);
		
		HttpSession session = request.getSession();
		// valid for 30 mins
		int user_id = (Integer) session.getAttribute(Info.SESSION_USER_ID);
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

		if (role_id == 0 || role_id == 1) {
			customer.setOperator_id(user_id);
		} else {
			customer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
		}

		customer.setFirst_name(request.getParameter(Info.CUSTOMER_TABLE_FNAME));
		customer.setLast_name(request.getParameter(Info.CUSTOMER_TABLE_LNAME));
		customer.setEmail_id(request.getParameter(Info.CUSTOMER_TABLE_EMAIL));
		customer.setPhone(Long.parseLong(request.getParameter(Info.CUSTOMER_TABLE_PHONE)));
		customer.setAddress1(request.getParameter(Info.CUSTOMER_TABLE_ADD1));
		customer.setAddress2(request.getParameter(Info.CUSTOMER_TABLE_ADD2));
		customer.setZipcode(Integer.parseInt(request.getParameter(Info.CUSTOMER_TABLE_ZIP)));
		customer.setCity(request.getParameter(Info.CUSTOMER_TABLE_CITY));
		customer.setState(request.getParameter(Info.CUSTOMER_TABLE_STATE));
		
		CustomerService custServ = new CustomerService();

		int code = custServ.updateCustomer(customer,id);

		if(code == 0) session.setAttribute("msg", "Please try again!");
		else session.setAttribute("msg", "Customer updated successfully!");
		
		response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
	}

}
