package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RetailerBean;
import service.RetailerService;
import utilities.Info;

/**
 * Servlet implementation class UpdateRetailerServlet
 */
public class UpdateRetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRetailerServlet() {
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
		String ret_id = request.getParameter("retailer_id");
		RetailerService service = new RetailerService();
		RetailerBean retailer = new RetailerBean();

		retailer.setRetailer_id(Integer.parseInt(ret_id));
		retailer = service.getRetailerDetails(retailer);
		HttpSession session = request.getSession();
		session.setAttribute("retailer", retailer);

		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		if (role_id == Info.ADMIN_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.UPDATE_RETAILER_PAGE);
		} else if (role_id == Info.OPERATOR_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.UPDATE_RETAILER_BY_OPERATOR_PAGE);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RetailerService service = new RetailerService();
		RetailerBean retailer = new RetailerBean();

		retailer.setRetailer_id(Integer.parseInt(request.getParameter("retailer_id")));

		retailer.setCompany_name(request.getParameter("company_name"));
		retailer.setContact1(request.getParameter("contact1"));
		retailer.setContact2(request.getParameter("contact2"));
		retailer.setAddress1(request.getParameter("address1"));
		retailer.setAddress2(request.getParameter("address2"));
		retailer.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		retailer.setCity(request.getParameter("city"));
		retailer.setState(request.getParameter("state"));
		retailer.setStb_limit(Integer.parseInt(request.getParameter("stb_limit")));
		retailer.setCredit_limit(Double.parseDouble(request.getParameter("credit_limit")));
		retailer.setComm_percent(Double.parseDouble(request.getParameter("comm_percent")));
		retailer.setService_charges(Double.parseDouble(request.getParameter("service_charges")));
		retailer.setInventory_cost(Double.parseDouble(request.getParameter("inventory_cost")));
		retailer.setAssigned_to_retailer(Integer.parseInt(request.getParameter("assigned_to_retailer")));

		int finalResult = service.updateRetailer(retailer);

		HttpSession session = request.getSession();
		int user_id = (Integer) session.getAttribute(Info.SESSION_USER_ID);
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

		if (role_id == 0 || role_id == 1) {
			retailer.setOperator_id(user_id);
		} else {
			retailer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
		}

		if (finalResult == 0)
			session.setAttribute("msg", "Please try again!");
		else
			session.setAttribute("msg", "Retailer updated successfully!");

		role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		if (role_id == Info.ADMIN_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.MESSAGE_PAGE);
		} else if (role_id == Info.OPERATOR_ROLE_ID) {
			response.sendRedirect(request.getContextPath() + Info.OPERATOR_MESSAGE_PAGE);
		}
	}

}
