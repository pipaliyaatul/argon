package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.LoginBean;
import service.InfinityService;
import utilities.Info;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// Logout
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
		response.sendRedirect(loginURI);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		String uname = request.getParameter(Info.LOGIN_TABLE_USER_NAME);
		String pwd = request.getParameter(Info.LOGIN_TABLE_USER_PASSWORD);

		LoginBean user = new LoginBean();
		user.setUser_name(uname);
		user.setUser_password(pwd);
		InfinityService iservice = new InfinityService();
		user = iservice.validateLogin(user);

		if (user != null) {
			int role = user.getUser_role_Id();
			HttpSession session = request.getSession();
			// valid for 30 mins
			session.setMaxInactiveInterval(Info.SESSION_TIME);
			session.setAttribute(Info.SESSION_USER_ID, user.getUser_Id());
			session.setAttribute(Info.SESSION_USER_NAME, user.getUser_name());
			session.setAttribute(Info.SESSION_USER_ROLE_ID, user.getUser_role_Id());
			if (role == Info.ADMIN_ROLE_ID) {
				
				response.sendRedirect(request.getContextPath() + Info.ADMIN_HOME_PAGE);
			} else if (role == Info.OPERATOR_ROLE_ID) {
				System.out.println("op");
				if (user.getUser_password().equals(Info.DEFAULT_PASSWORD)) {
					response.sendRedirect(request.getContextPath() + Info.CHANGE_PWD_PAGE);
				} else {
					response.sendRedirect(request.getContextPath() + Info.OPERATOR_HOME_PAGE);
				}
			} else if (role == Info.RETAILER_ROLE_ID) {
				System.out.println("retail");

			} else if (role == Info.CUSTOMER_ROLE_ID) {
				
				
				System.out.println("cust");
				if (user.getUser_password().equals(Info.DEFAULT_PASSWORD)) {
					response.sendRedirect(request.getContextPath() + Info.CHANGE_PWD_PAGE);
				} else {
					InfinityService iService = new InfinityService();
					String opName = iService.getOperatorForCustomer(user);
					String retailerName = iService.getRetailerForCustomer(user);
					System.out.println(user.getUser_Id());
					System.out.println(opName+" "+retailerName);
					session.setAttribute("op_name", opName);
					session.setAttribute("retailer_name", retailerName);
					response.sendRedirect(request.getContextPath() + Info.CUSTOMER_HOME_PAGE);
				}
			} 
			else 
			{
				String errorMessage="Sorry Your Username or Password is invalid";
				request.getSession().setAttribute("msg", errorMessage);
				response.sendRedirect(request.getContextPath() + Info.GENERAL_MESSAGE_PAGE);
				//out.print("Sorry username or password is Incorrect");
			}

		} else {
			//out.print("Sorry username or password is Incorrect");
			String errorMessage="Sorry!! Your Username or Password is Invalid";
			request.getSession().setAttribute("msg", errorMessage);
			response.sendRedirect(request.getContextPath() + Info.GENERAL_MESSAGE_PAGE);
		}
		out.close();

	}

}
