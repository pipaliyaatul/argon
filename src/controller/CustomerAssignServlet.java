package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;
import model.OperatorBean;
import model.RetailerBean;
import service.CustomerService;
import service.OperatorService;
import service.RetailerService;
import utilities.Info;

/**
 * Servlet implementation class CustomerAssignServlet
 */
public class CustomerAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("customer_id", request.getParameter("id"));
		if(request.getParameter("action").equals("retailer")){
			RetailerService retailerService = new RetailerService();
			ArrayList<RetailerBean> retailerList = retailerService.getAllRetailerAvailable();
			session.setAttribute("retailerList", retailerList);
			response.sendRedirect(request.getContextPath()+Info.ADMIN_HOME_PAGE_ASSIGN_RETAILER_TO_CUSTOMER);
		}else if(request.getParameter("action").equals("operator")){
			OperatorService operatorService = new OperatorService();
			ArrayList<OperatorBean> operatorList = operatorService.getAllOperatorAvailable();
			session.setAttribute("operatorList", operatorList);
			response.sendRedirect(request.getContextPath()+Info.ADMIN_HOME_PAGE_ASSIGN_OPERATOR_TO_CUSTOMER);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService();
		ArrayList<CustomerBean> customerList = new ArrayList<CustomerBean>();
		HttpSession session = request.getSession();
		
		if(request.getParameter("action").equals("retailer")){
			customerList = service.getAllUnassignedRetailer();	
			session.setAttribute("customerList", customerList);
			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_DISPLAY_NEW_REGISTER_CUSTOMER);
		}else if(request.getParameter("action").equals("operator")){
			customerList = service.getAllUnassignedOperator();	
			session.setAttribute("customerList", customerList);
			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_VIEW_CUSTOMERS_WITHOUT_OPERATORS);
		}
	}

}
