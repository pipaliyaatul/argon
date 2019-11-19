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
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginBean user = new LoginBean();
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("cpassword");
		if (password.equals(confirm_password)) {
			user.setUser_password(password);
			user.setUser_Id((Integer) request.getSession().getAttribute(Info.SESSION_USER_ID));
			InfinityService is = new InfinityService();
			HttpSession session = request.getSession();
			if (is.changePassword(user)) {
				session.setAttribute("msg", "Changed Password succesfully!");
				int role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
				if (role_id == Info.ADMIN_ROLE_ID) {
					response.sendRedirect(request.getContextPath() + Info.MESSAGE_PAGE);
				} else if (role_id == Info.OPERATOR_ROLE_ID) {
					response.sendRedirect(request.getContextPath() + Info.OPERATOR_MESSAGE_PAGE);
				}
				else if(role_id == Info.CUSTOMER_ROLE_ID){
					System.out.println("Redirect to customer");
					response.sendRedirect(request.getContextPath() + Info.LOGIN_PAGE);
					
				}
			} else {
				session.setAttribute("msg", "Could not Change Password succesfully!");
			}
		} else {
				System.out.println("Change Pwd Servlet else part");
		}

	}

}
