package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import utilities.Info;

/**
 * Servlet implementation class CustomerAssignUpdateServlet
 */
public class CustomerAssignUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAssignUpdateServlet() {
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
		HttpSession session = request.getSession();
		if(request.getParameter("action").equals("retailer")){
			AdminService aService = new AdminService();
			if(aService.updateAssignedRetailer(request.getParameter("customer_id"),request.getParameter("retailer_id"))){
				session.setAttribute("msg", "Assigned Retailer Succesfully");
			}
			else{
				session.setAttribute("msg", "Could not assign Retailer");
			}
			response.sendRedirect(request.getContextPath() + Info.MESSAGE_PAGE);
		}
		else if(request.getParameter("action").equals("operator")){
			AdminService aService = new AdminService();
			if(aService.updateAssignedOperator(request.getParameter("customer_id"),request.getParameter("operator_id"))){
				session.setAttribute("msg", "Assigned Operator Succesfully");
			}
			else{
				session.setAttribute("msg", "Could not assign Operator");
			}
			response.sendRedirect(request.getContextPath() + Info.MESSAGE_PAGE);
		}
	}

}
