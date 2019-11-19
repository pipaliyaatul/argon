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
 * Servlet implementation class UpdateCustByOperator
 */
public class UpdateCustByOperator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustByOperator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		CustomerBean customer = new CustomerBean();
		int id = Integer.parseInt(request.getParameter("custId"));
//		// For the form date
		customer.setCustomer_id(id);
//		
		HttpSession session = request.getSession();
//		// valid for 30 mins
		int user_id = (Integer) session.getAttribute(Info.SESSION_USER_ID);
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

//		if (role_id == 0 || role_id == 1) {
//			customer.setOperator_id(user_id);
//		} else {
//			customer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
//		}
//		
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
		
		response.sendRedirect(request.getContextPath()+Info.OPERATOR_MESSAGE_PAGE);
	}

}
