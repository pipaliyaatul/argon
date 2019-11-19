package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginBean;
import service.InfinityService;
import utilities.Info;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		System.out.println("UserId for deleting is: "+user_id);
		HttpSession session= request.getSession();
		LoginBean user = new LoginBean();
		user.setUser_Id(user_id);
//		System.out.println(user_id);
		InfinityService is = new InfinityService();
		if(is.deleteUser(user)){
			session.setAttribute("msg", "Deleted User with id: "+user_id+"Succesfully");
		}
		else{
			session.setAttribute("msg", "Due to integrity constraints, Could not delete User with id: "+user_id);	
		}
		int role_id = (Integer)session.getAttribute(Info.SESSION_USER_ROLE_ID);
		if(role_id ==Info.ADMIN_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.MESSAGE_PAGE);
		}
		else if(role_id == Info.OPERATOR_ROLE_ID){
			response.sendRedirect(request.getContextPath()+Info.OPERATOR_MESSAGE_PAGE);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
