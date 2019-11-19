package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OperatorBean;
import service.OperatorService;
import utilities.Info;

/**
 * Servlet implementation class ViewOperatorsServlet
 */
public class ViewOperatorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOperatorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OperatorService operatorService = new OperatorService();
		ArrayList<OperatorBean> operatorList = operatorService.getAllOperator();
		HttpSession session = request.getSession();
		session.setAttribute("operatorList", operatorList);
		
//		System.out.println("in view operators servlet - Admin dashboard"+operatorList);
		response.sendRedirect(request.getContextPath()+Info.DISPLAY_ALL_OPERATORS);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
