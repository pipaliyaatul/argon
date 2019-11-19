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
 * Servlet implementation class RetailerServlet
 */
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerServlet() {
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
		RetailerService retailerService = new RetailerService();
		ArrayList<RetailerBean> retailerList = retailerService.getAllRetailerAvailable();
		HttpSession session = request.getSession();
		session.setAttribute("retailerList", retailerList);
		response.sendRedirect(request.getContextPath()+Info.REGISTER_CUSTOMER_PAGE);
	}

}
