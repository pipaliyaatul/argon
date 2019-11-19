package utilities;


public final class Info {

	//Pages

	public static final String UPDATE_RETAILER_BY_OPERATOR_PAGE = "/JSPFrontPages/Operator/UpdateRetailerByOperator.jsp";
	public static final String LOGIN_PAGE = "/JSPFrontPages/Login.jsp";
	public static final String OPERATOR_HOME_PAGE = "/JSPFrontPages/Operator/OperatorDashBoard.jsp";
	public static final String OPERATOR_HOME_PAGE_DISPLAY_CUSTOMER = "/JSPFrontPages/Operator/ViewCustomer.jsp";
	public static final String MESSAGE_PAGE = "/JSPFrontPages/Message.jsp";
	public static final String RETAILER_HOME_PAGE = "/index.jsp";
	public static final String CUSTOMER_HOME_PAGE = "/JSPFrontPages/Customer/CustomerDashBoard.jsp";
	public static final String ADMIN_HOME_PAGE = "/JSPFrontPages/Admin/AdminDashBoard.jsp";
	public static final String DISPLAY_ALL_RETAILER = "/JSPFrontPages/Operator/Display.jsp";
	public static final String DISPLAY_ALL_CUSTOMER ="";
	public static final String DISPLAY_ALL_OPERATORS = "/JSPFrontPages/Admin/ViewAllOperators.jsp";
	public static final String OPERATOR_HOME_PAGE_DISPLAY_RETAILER = "/JSPFrontPages/Operator/ViewRetailers.jsp";
	public static final String ADMIN_HOME_PAGE_DISPLAY_CUSTOMER = "/JSPFrontPages/Admin/ViewCustomerByAdmin.jsp";
	public static final String ADMIN_HOME_PAGE_UPDATE_CUSTOMER = "/JSPFrontPages/Admin/UpdateCustomerByAdmin.jsp";
	public static final String ADMIN_HOME_PAGE_DISPLAY_RETAILER = "/JSPFrontPages/Admin/ViewRetailersByAdmin.jsp";
	public static final String ADMIN_HOME_PAGE_DISPLAY_NEW_REGISTER_CUSTOMER="/JSPFrontPages/Admin/ViewNewRegisteredCustomer.jsp";
	public static final String REGISTER_CUSTOMER_PAGE = "/JSPFrontPages/Customer/RegisterCustomer.jsp";
	public static final String OPERATOR_HOME_PAGE_REGISTER_CUSTOMER = "/JSPFrontPages/Operator/RegisterCustomerByOperator.jsp";
	public static final String UPDATE_RETAILER_PAGE = "/JSPFrontPages/Operator/UpdateRetailer.jsp";
	public static final String ANALYTICS = "/JSPFrontPages/Admin/Analytics.jsp";
	public static final String ANALYTICSPIE = "/JSPFrontPages/Admin/RetailerAnalytics.jsp";
	public static final String OPERATOR_MESSAGE_PAGE = "/JSPFrontPages/OperatorMessage.jsp";
	public static final String CHANGE_PWD_PAGE = "/JSPFrontPages/ChangePassword.jsp";
	public static final String UPDATE_OPERATOR_PAGE = "/JSPFrontPages/Operator/UpdateOperator.jsp";
	public static final String OPERATOR_HOME_PAGE_UPDATE_CUSTOMER = "/JSPFrontPages/Operator/UpdateCustomerByOperator.jsp";
	public static final String ADMIN_HOME_PAGE_VIEW_CUSTOMERS_WITHOUT_OPERATORS="/JSPFrontPages/Admin/ViewCustomersWithoutOperators.jsp";
	public static final String ADMIN_HOME_PAGE_ASSIGN_RETAILER_TO_CUSTOMER = "/JSPFrontPages/Admin/AssignRetailerToCustomer.jsp";
	public static final String ADMIN_HOME_PAGE_ASSIGN_OPERATOR_TO_CUSTOMER = "/JSPFrontPages/Admin/AssignOperatorToCustomer.jsp";
	public static final String GENERAL_MESSAGE_PAGE = "/JSPFrontPages/GeneralMessage.jsp";
	
	public static final String DEFAULT_PASSWORD = "password";
	public static final int DEFAULT_OPERATOR_ID = 27;
	public static final int DEFAULT_RETAILER_ID = 27;
	
	//Roles
	public static final int ADMIN_ROLE_ID = 0;
	public static final int OPERATOR_ROLE_ID = 1;
	public static final int RETAILER_ROLE_ID = 2;
	public static final int CUSTOMER_ROLE_ID = 3;
	
	//Roles Folder
	public static final String ADMIN_FOLDER = "Admin";
	public static final String OPERATOR_FOLDER = "Operator";
	public static final String RETAILER_FOLDER = "Retailer";
	public static final String CUSTOMER_FOLDER = "Customer";
	
	//session
	public static final String SESSION_USER_ID = "user_id";
	public static final String SESSION_USER_ROLE_ID = "role_id";
	public static final String SESSION_USER_NAME = "user_name";
	public static final int SESSION_TIME = 60*30;
	
	//table login
	public static final String LOGIN_TABLE = "Argon_Infinity_Login";
	public static final String LOGIN_TABLE_ROLE_ID = "user_role_Id";
	public static final String LOGIN_TABLE_USER_ID = "user_Id";
	public static final String LOGIN_TABLE_USER_NAME = "user_name";
	public static final String LOGIN_TABLE_USER_PASSWORD = "user_password";
	
	//table operator
	public static final String OPERATOR_TABLE = "Argon_Infinity_Operator";
	public static final String OPERATOR_TABLE_OP_ID = "operator_id";
	public static final String OPERATOR_TABLE_FIRST_NAME = "first_name";
	public static final String OPERATOR_TABLE_LAST_NAME = "last_name";
	public static final String OPERATOR_TABLE_EMAIL = "email_id";
	public static final String OPERATOR_TABLE_PHONE = "phone";
	public static final String OPERATOR_TABLE_SSTART = "shift_start_time";
	public static final String OPERATOR_TABLE_SEND = "shift_end_time";
	public static final String OPERATOR_TABLE_CLIMIT = "customer_limit";
	public static final String OPERATOR_TABLE_CON = "created_on";
	public static final String OPERATOR_TABLE_TOTAL_CUST = "total_active_customer";
	
	//table customer
	public static final String CUSTOMER_TABLE = "Argon_Infinity_Customer";
	public static final String CUSTOMER_TABLE_CUST_ID ="customer_id";
	public static final String CUSTOMER_TABLE_OP_ID ="operator_id";
	public static final String CUSTOMER_TABLE_RET_ID ="retailer_id";
	public static final String CUSTOMER_TABLE_FNAME ="first_name";
	public static final String CUSTOMER_TABLE_LNAME ="last_name";
	public static final String CUSTOMER_TABLE_EMAIL ="email_id";
	public static final String CUSTOMER_TABLE_PHONE ="phone";
	public static final String CUSTOMER_TABLE_ADD1 ="address1";
	public static final String CUSTOMER_TABLE_ADD2 ="address2";
	public static final String CUSTOMER_TABLE_ZIP ="zipcode";
	public static final String CUSTOMER_TABLE_CITY ="city";
	public static final String CUSTOMER_TABLE_STATE ="state";
	public static final String CUSTOMER_TABLE_CREATED ="created_on";
	
	//TABLE RETAILER
	public static final String RETAILER_TABLE = "Argon_Infinity_Retailer";
	public static final String RETAILER_TABLE_RET_ID = "retailer_id";
	public static final String RETAILER_TABLE_OP_ID = "operator_id";
	public static final String RETAILER_TABLE_COMPANY = "company_name";
	public static final String RETAILER_TABLE_CONTACT1 = "contact1";
	public static final String RETAILER_TABLE_CONTACT2 = "contact2";
	public static final String RETAILER_TABLE_ADD1 = "address1";
	public static final String RETAILER_TABLE_ADD2 = "address2";
	public static final String RETAILER_TABLE_ZIP = "zipcode";
	public static final String RETAILER_TABLE_CITY = "city";
	public static final String RETAILER_TABLE_STATE = "state";
	public static final String RETAILER_TABLE_STB_LIMIT = "stb_limit";
	public static final String RETAILER_TABLE_CREDIT_LIMIT = "credit_limit";
	public static final String RETAILER_TABLE_COMM_PERCENT = "comm_percentage";
	public static final String RETAILER_TABLE_SERVICE_CHARGE = "service_charges";
	public static final String RETAILER_TABLE_INVENTORY = "inventory_list";
	public static final String RETAILER_TABLE_CR_ON = "created_on";
	public static final String RETAILER_TABLE_INVENTORY_COST = "inventory_cost";
	public static final String RETAILER_TABLE_ASG_RETAILER = "assigned_to_retailer";
	
	public static final String[] ALLOWED_OPERATOR_FILES = {
			"OperatorDashBoard.jsp", "RegisterCustomerByOperator.jsp", "RegisterRetailerByOperator.jsp",
			"UpdateCustomerByOperator.jsp", "ViewCustomer.jsp", "ViewRetailers.jsp",
			"ChangePassword.jsp", "OperatorMessage.jsp", "UpdateRetailerByOperator.jsp"
	};
	public static final String[] ALLOWED_ADMIN_FILES = {
			"AdminDashBoard.jsp", "AssignOperatorToCustomer.jsp", "AssignRetailerToCustomer.jsp",
			"UpdateCustomerByAdmin.jsp", "ViewAllOperators.jsp", "ViewCustomerByAdmin.jsp",
			"ViewCustomersWithoutOperators.jsp", "ViewNewRegisteredCustomer.jsp",
			"ViewRetailersByAdmin.jsp", "RegisterCustomer.jsp", "RegisterOperator.jsp",
			"UpdateOperator.jsp", "UpdateRetailer.jsp", "RegisterRetailer.jsp",
			"Message.jsp", "RetailerAnalytics.jsp", "Analytics.jsp"
	};
	public static final String[] ALLOWED_CUSTOMER_FILES = {
			"CustomerDashBoard.jsp", "ChangePassword.jsp","CustomerDashBoard.jsp"
	};
	
	public static final String[] ALLOWED_GENERAL_FILES = {
			"RegisterCustomerBySelf.jsp", "Login.jsp","RedirectAfterLogin.jsp", "GeneralMessage.jsp"
	};
	


	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
}
