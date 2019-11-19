package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RetailerBean;
import service.RetailerService;
import utilities.Info;

/**
 * Servlet implementation class RegisterRetailerServlet
 */
public class RegisterRetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRetailerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		System.out.println("in doGet of registerRetailer");
//		RetailerService retailerService = new RetailerService();
//		ArrayList<RetailerBean> retailerList = retailerService.getAllRetailer();
//		HttpSession session = request.getSession();
//		session.setAttribute("retailerList", retailerList);
		HttpSession session = request.getSession();
//		System.out.println("in register retailer servlet "+retailerList);
		
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);

		if (role_id == Info.OPERATOR_ROLE_ID) {

			RetailerService retailerService = new RetailerService();
			ArrayList<RetailerBean> retailerList = retailerService.getAllRetailer(session.getAttribute(Info.SESSION_USER_ID));
//			HttpSession session = request.getSession();
			session.setAttribute("retailerList", retailerList);
			
			System.out.println("in register retailer servlet "+retailerList);
//			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_DISPLAY_RETAILER);
			response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE_DISPLAY_RETAILER);

		} else if(role_id == Info.ADMIN_ROLE_ID){
			
		
			RetailerService retailerService = new RetailerService();
			ArrayList<RetailerBean> retailerList = retailerService.getAllRetailer();
//			HttpSession session = request.getSession();
			session.setAttribute("retailerList", retailerList);
			
			System.out.println("in register retailer servlet "+retailerList);
			response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE_DISPLAY_RETAILER);
		}
		else{
			String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
			response.sendRedirect(loginURI);
		}
		
		//request.getRequestDispatcher("/JSPFrontPages/Admin/ViewRetailersByAdmin.jsp").forward(request, response);
//		request.getRequestDispatcher(Info.DISPLAY_ALL_RETAILER).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RetailerBean retailer = new RetailerBean(); 
		
		System.out.println("In post method of RegisterRetailerServlet");
		String compname = request.getParameter(Info.RETAILER_TABLE_COMPANY);
		String contact1 = request.getParameter(Info.RETAILER_TABLE_CONTACT1);
		String contact2 = request.getParameter(Info.RETAILER_TABLE_CONTACT2);
		String add1 = request.getParameter(Info.RETAILER_TABLE_ADD1);
		String add2 = request.getParameter(Info.RETAILER_TABLE_ADD2);
		int zipcode = Integer.parseInt(request.getParameter(Info.RETAILER_TABLE_ZIP));
		String city = request.getParameter(Info.RETAILER_TABLE_CITY);
		String state = request.getParameter(Info.RETAILER_TABLE_STATE);
		int stblimit = Integer.parseInt(request.getParameter(Info.RETAILER_TABLE_STB_LIMIT));
		double creditlimit = Double.parseDouble(request.getParameter(Info.RETAILER_TABLE_CREDIT_LIMIT));
		double commpercent = Double.parseDouble(request.getParameter(Info.RETAILER_TABLE_COMM_PERCENT));
		double servicecharge = Double.parseDouble(request.getParameter(Info.RETAILER_TABLE_SERVICE_CHARGE));
		//String creationdate = request.getParameter(Info.RETAILER_TABLE_CR_ON);
		double inventorycost = Double.parseDouble(request.getParameter(Info.RETAILER_TABLE_INVENTORY_COST));
		int assignedtoretailer = Integer.parseInt(request.getParameter(Info.RETAILER_TABLE_ASG_RETAILER));
		
		HttpSession session = request.getSession();
		//valid for 30 mins
		int user_id = (Integer) session.getAttribute(Info.SESSION_USER_ID);
		int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		
		if(role_id==0 || role_id==1){
			retailer.setOperator_id(user_id);
		}
		else{
			retailer.setOperator_id(Info.DEFAULT_OPERATOR_ID);
		}
		
		
		retailer.setCompany_name(compname);
		retailer.setContact1(contact1);
		retailer.setContact2(contact2);
		retailer.setAddress1(add1);
		retailer.setAddress2(add2);
		retailer.setZipcode(zipcode);
		retailer.setCity(city);
		retailer.setState(state);
		retailer.setStb_limit(stblimit);
		retailer.setCredit_limit(creditlimit);
		retailer.setComm_percent(commpercent);
		retailer.setService_charges(servicecharge);
		
		System.out.println("Created on: "+retailer.getCreated_on());
		retailer.setInventory_cost(inventorycost);
		retailer.setAssigned_to_retailer(assignedtoretailer);
		
		RetailerService retailerService = new RetailerService();
		int finalResult = retailerService.registerRetailer(retailer);
		
		if(finalResult == 0) session.setAttribute("msg", "Please try again!");
		else session.setAttribute("msg", "Retailer registered successfully!");
		
		role_id = (Integer)session.getAttribute(Info.SESSION_USER_ROLE_ID);
		if(role_id ==Info.ADMIN_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
		}
		else if(role_id == Info.OPERATOR_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.OPERATOR_MESSAGE_PAGE);
		}
		
	}

}
