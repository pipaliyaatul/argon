package utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		String loginURI = request.getContextPath() + "/JSPFrontPages/Login.jsp";
		String reqPath = request.getRequestURI();
		String[] reqPathSplit = reqPath.split("[/]");
		String reqFolder = reqPathSplit[reqPathSplit.length - 2 > 0 ? reqPathSplit.length - 2 : 0];
		String reqFile = reqPathSplit[reqPathSplit.length - 1 > 0 ? reqPathSplit.length - 1 : 0];

		if (allowedFilesGeneral(reqFile)) {
			chain.doFilter(request, response);
			return;
		}

		System.out.println("reqFolder " + reqFolder + " reqFile " + reqFile);
		Integer role_id = 0;

		if (session == null || session.getAttribute(Info.SESSION_USER_ROLE_ID) == null) {
			response.sendRedirect(loginURI);
			return;
		}

		role_id = (Integer) session.getAttribute(Info.SESSION_USER_ROLE_ID);
		// System.out.println(role_id);
		if (role_id == Info.ADMIN_ROLE_ID) {
			if (allowedFilesAdmin(reqFile)) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (role_id == Info.OPERATOR_ROLE_ID) {
			if (allowedFilesOperator(reqFile)) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (role_id == Info.RETAILER_ROLE_ID) {
			if (allowedFilesRetailer(reqFile)) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (role_id == Info.CUSTOMER_ROLE_ID) {
			if (allowedFilesCustomer(reqFile)) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else {
			response.sendRedirect(loginURI);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private boolean allowedFilesGeneral(String file) {
		String[] allowedfiles = Info.ALLOWED_GENERAL_FILES;
		System.out.println("file:" + file);
		for (String tmp : allowedfiles) {
			if (tmp.equals(file)) {
				return true;
			}
		}
		return false;
	}

	private boolean allowedFilesAdmin(String file) {
		String[] allowedfiles = Info.ALLOWED_ADMIN_FILES;
		System.out.println("file:" + file);
		for (String tmp : allowedfiles) {
			System.out.println(tmp);
			if (tmp.equals(file)) {
				return true;
			}
		}
		return false;
	}

	private boolean allowedFilesOperator(String file) {
		String[] allowedfiles = Info.ALLOWED_OPERATOR_FILES;
		System.out.println("file:" + file);
		for (String tmp : allowedfiles) {
			if (tmp.equals(file)) {
				return true;
			}
		}
		return false;
	}

	private boolean allowedFilesRetailer(String file) {
		String[] allowedfiles = { " " };
		System.out.println("file:" + file);
		for (String tmp : allowedfiles) {
			if (tmp.equals(file)) {
				return true;
			}
		}
		return false;
	}

	private boolean allowedFilesCustomer(String file) {
		String[] allowedfiles = Info.ALLOWED_CUSTOMER_FILES;
		System.out.println("file:" + file);
		for (String tmp : allowedfiles) {
			if (tmp.equals(file)) {
				return true;
			}
		}
		return false;
	}

}
