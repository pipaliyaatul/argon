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
 * Servlet implementation class RegCustByOperatorServlet
 */
public class RegCustByOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegCustByOperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("inside RegCustByOperatorServet");
		ArrayList<RetailerBean> retailerList = new ArrayList<RetailerBean>();
		RetailerService rs = new RetailerService();
		System.out.println("inside RegCustByOperatorServet before query");
		retailerList = rs.getAllRetailerAvailableByOperator(session.getAttribute(Info.SESSION_USER_ID));
		System.out.println("inside RegCustByOperatorServet after query");
		System.out.println(retailerList);
		session.setAttribute("retailerList", retailerList);
		System.out.println("inside RegCustByOperatorServet before sending to page "+ Info.OPERATOR_HOME_PAGE_REGISTER_CUSTOMER);
		response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE_REGISTER_CUSTOMER);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
