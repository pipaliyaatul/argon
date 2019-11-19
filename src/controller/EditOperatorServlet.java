package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OperatorBean;
import model.RetailerBean;
import service.OperatorService;
import service.RetailerService;
import utilities.Info;

/**
 * Servlet implementation class EditOperatorServlet
 */
public class EditOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	//	System.out.println("Opr ID: "+ opr_id);
		
		OperatorService service = new OperatorService();
		OperatorBean operator = new OperatorBean();
		
		operator.setOperator_id(Integer.parseInt(request.getParameter("id")));
		System.out.println(request.getParameter("id"));
		operator = service.getOperatorById(operator);
		
		HttpSession session = request.getSession();
		session.setAttribute("operator", operator);
		response.sendRedirect(request.getContextPath()+Info.UPDATE_OPERATOR_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		OperatorService service = new OperatorService();
		OperatorBean operator = new OperatorBean();
		
		operator.setFirst_name(request.getParameter("first_name"));
		operator.setLast_name(request.getParameter("last_name"));
		operator.setEmail_id(request.getParameter("email_id"));
		operator.setPhone(Integer.parseInt(request.getParameter("phone")));
		operator.setShift_start_time(request.getParameter("shift_start_time"));
		operator.setShift_end_time(request.getParameter("shift_end_time"));
		operator.setTotal_active_customer(Integer.parseInt(request.getParameter("total_active_customer")));
	//	operator.setCreated_on(request.getParameter("created_on"));
		operator.setOperator_id(Integer.parseInt(request.getParameter("operator_id")));
		
		int finalResult = service.updateOperator(operator);
		HttpSession session = request.getSession();		
	
		if(finalResult == 0) session.setAttribute("msg", "Please try again!");
		else session.setAttribute("msg", "Operator updated successfully!");
		
		response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
		
	}

}
