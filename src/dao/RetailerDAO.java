package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import model.LoginBean;
import model.OperatorBean;
import model.RetailerBean;
import service.InfinityService;
import utilities.DbCon;
import utilities.Info;


public class RetailerDAO {
	
	public int registerRetailer(RetailerBean retailer) {
		LoginBean user = new LoginBean();
		user.setUser_name(retailer.getCompany_name());
		user.setUser_password(Info.DEFAULT_PASSWORD);
		user.setUser_role_Id(Info.RETAILER_ROLE_ID);
		InfinityService service = new InfinityService();
		int user_id = service.registerUser(user).getUser_Id();
		
		
		Connection con = DbCon.getConnection();
		int result = 0;
		
		try {
			String qry = "Insert into "+Info.RETAILER_TABLE+" (retailer_id, operator_id, company_name, contact1, contact2, address1,"
					+ "address2, zipcode, city, state, stb_limit, credit_limit, comm_percentage, service_charges, created_on, "
					+ "inventory_cost, assigned_to_retailer) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 	// put query here
						
			PreparedStatement st = con.prepareStatement(qry);
			
			//service.registerUser(user);
			System.out.println("Retailer ID: " +user_id);
			System.out.println("Operator ID: "+retailer.getOperator_id());
			st.setInt(1, user_id);  
			st.setInt(2, retailer.getOperator_id());
			//con=DbCon.getConnection();
			st.setString(3, retailer.getCompany_name());
			st.setString(4, retailer.getContact1());
			st.setString(5, retailer.getContact2());
			st.setString(6, retailer.getAddress1());
			st.setString(7, retailer.getAddress2());
			st.setInt(8, retailer.getZipcode());
			st.setString(9, retailer.getCity());
			st.setString(10, retailer.getState());
			st.setInt(11, retailer.getStb_limit());
			st.setDouble(12, retailer.getCredit_limit());
			st.setDouble(13, retailer.getComm_percent());
			st.setDouble(14, retailer.getService_charges());
			st.setTimestamp(15, Info.getCurrentTimeStamp());
			st.setDouble(16, retailer.getInventory_cost());
			st.setInt(17, retailer.getAssigned_to_retailer());
			
			result = st.executeUpdate();
			return result;	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return result;
	}
	
	public ArrayList<RetailerBean> getAllRetailer() {
		Connection con = DbCon.getConnection();
		ArrayList<RetailerBean> retailerList = new ArrayList<RetailerBean>();
		try {
			String qry = "select "+ Info.RETAILER_TABLE_RET_ID+","+
						Info.RETAILER_TABLE_COMPANY +","+ 
						Info.RETAILER_TABLE_CONTACT1 
					+" from "+Info.RETAILER_TABLE; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RetailerBean retailer = new RetailerBean();
				
				retailer.setCompany_name(rs.getString(Info.RETAILER_TABLE_COMPANY));
				retailer.setRetailer_id(rs.getInt(Info.RETAILER_TABLE_RET_ID));
				retailer.setContact1(rs.getString(Info.RETAILER_TABLE_CONTACT1));
				
				retailerList.add(retailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return retailerList;
	}
	
	
	
	
	
	public ArrayList<RetailerBean> getAllRetailerAvailable() {
		Connection con = DbCon.getConnection();
		ArrayList<RetailerBean> retailerList = new ArrayList<RetailerBean>();
		try {
			
//			
			String qry = "select "+ Info.RETAILER_TABLE_RET_ID + ","+
						Info.RETAILER_TABLE_COMPANY +","+ 
						Info.RETAILER_TABLE_CONTACT1 
						
					+" from "+Info.RETAILER_TABLE + " R where "+Info.RETAILER_TABLE_ASG_RETAILER+  " > "+ 
					" (select count(*) from "+Info.CUSTOMER_TABLE + "  C  WHERE  C."+ Info.CUSTOMER_TABLE_RET_ID+ 
					
					" = R."+ Info.RETAILER_TABLE_RET_ID+ " )"	
					; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
//			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RetailerBean retailer = new RetailerBean();
				
				retailer.setCompany_name(rs.getString(Info.RETAILER_TABLE_COMPANY));
				retailer.setRetailer_id(rs.getInt(Info.RETAILER_TABLE_RET_ID));
				retailer.setContact1(rs.getString(Info.RETAILER_TABLE_CONTACT1));
				
				retailerList.add(retailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return retailerList;
	}
	
	
	
	
	
	
	
	
	
	
	public RetailerBean getRetailerById(RetailerBean retailer){
		Connection con = DbCon.getConnection();
		try {
			String qry = "select * from "+Info.RETAILER_TABLE+" where "+Info.RETAILER_TABLE_RET_ID+ " = ?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, retailer.getRetailer_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				retailer.setCompany_name(rs.getString(Info.RETAILER_TABLE_COMPANY));
				retailer.setContact1(rs.getString(Info.RETAILER_TABLE_CONTACT1));
				retailer.setContact2(rs.getString(Info.RETAILER_TABLE_CONTACT2));
				retailer.setAddress1(rs.getString(Info.RETAILER_TABLE_ADD1));
				retailer.setAddress2(rs.getString(Info.RETAILER_TABLE_ADD2));
				retailer.setZipcode(rs.getInt(Info.RETAILER_TABLE_ZIP));
				retailer.setCity(rs.getString(Info.RETAILER_TABLE_CITY));
				retailer.setState(rs.getString(Info.RETAILER_TABLE_STATE));
				retailer.setStb_limit(rs.getInt(Info.RETAILER_TABLE_STB_LIMIT));
				retailer.setCredit_limit(rs.getDouble(Info.RETAILER_TABLE_CREDIT_LIMIT));
				retailer.setComm_percent(rs.getDouble(Info.RETAILER_TABLE_COMM_PERCENT));
				retailer.setService_charges(rs.getDouble(Info.RETAILER_TABLE_SERVICE_CHARGE));
				retailer.setCreated_on(rs.getTimestamp(Info.RETAILER_TABLE_CR_ON));
				retailer.setInventory_cost(rs.getDouble(Info.RETAILER_TABLE_INVENTORY_COST));
				retailer.setAssigned_to_retailer(rs.getInt(Info.RETAILER_TABLE_ASG_RETAILER));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return retailer;
	}
	
	public int updateRetailer(RetailerBean retailer){
		Connection con = DbCon.getConnection();
		int result = 0;
		try {
			String qry = "Update "+Info.RETAILER_TABLE+" set COMPANY_NAME = ?, CONTACT1 = ?, CONTACT2 = ?, "
					+ "ADDRESS1 =?, ADDRESS2=?, ZIPCODE=?, CITY=?, STATE=?, STB_LIMIT=?,CREDIT_LIMIT=?,"
					+ "COMM_PERCENTAGE=?, SERVICE_CHARGES=?, INVENTORY_COST=?, ASSIGNED_TO_RETAILER=? "
					+ " where RETAILER_ID =?"; // put query here
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, retailer.getCompany_name());
			st.setString(2, retailer.getContact1());
			st.setString(3, retailer.getContact2());
			st.setString(4, retailer.getAddress1());
			st.setString(5, retailer.getAddress2());
			st.setInt(6, retailer.getZipcode());
			st.setString(7, retailer.getCity());
			st.setString(8, retailer.getState());
			st.setInt(9, retailer.getStb_limit());
			st.setDouble(10, retailer.getCredit_limit());
			st.setDouble(11, retailer.getComm_percent());
			st.setDouble(12, retailer.getService_charges());
		//	st.setTimestamp(13, Info.getCurrentTimeStamp());
			st.setDouble(13, retailer.getInventory_cost());
			st.setInt(14, retailer.getAssigned_to_retailer());
			st.setInt(15, retailer.getRetailer_id());
			
			result = st.executeUpdate();
//			System.out.println("result "+result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}		
		return result;
	}

	public ArrayList<RetailerBean> getAllRetailer(Object retailer_id) {
		
		int r_id=(Integer) retailer_id;
		Connection con = DbCon.getConnection();
		ArrayList<RetailerBean> retailerList = new ArrayList<RetailerBean>();
		try {
			String qry = "select "+ Info.RETAILER_TABLE_RET_ID+","+
						Info.RETAILER_TABLE_COMPANY +","+ 
						Info.RETAILER_TABLE_CONTACT1 
					+" from "+Info.RETAILER_TABLE+ " WHERE "+ Info.RETAILER_TABLE_OP_ID+ " =? " ; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RetailerBean retailer = new RetailerBean();
				
				retailer.setCompany_name(rs.getString(Info.RETAILER_TABLE_COMPANY));
				retailer.setRetailer_id(rs.getInt(Info.RETAILER_TABLE_RET_ID));
				retailer.setContact1(rs.getString(Info.RETAILER_TABLE_CONTACT1));
				
				retailerList.add(retailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return retailerList;
		
	}
	
	public ArrayList<RetailerBean> getAllRetailerAvailableByOperator(Object retailer_id) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		ArrayList<RetailerBean> retailerList = new ArrayList<RetailerBean>();
		try {
			
//			select * from argon_infinity_retailer R  
//			WHERE
//			assigned_to_retailer > (select count(*) from argon_infinity_customer C WHERE C.retailer_id = R.retailer_id);
//			
//			String qry = "select "+ Info.RETAILER_TABLE_RET_ID+","+
//					Info.RETAILER_TABLE_COMPANY +","+ 
//					Info.RETAILER_TABLE_CONTACT1 
//					
//				+" from "+Info.RETAILER_TABLE + " where "+Info.RETAILER_TABLE_ASG_RETAILER+ " > "+ 
//				" (select count(*) from "+Info.CUSTOMER_TABLE + " WHERE "+ Info.CUSTOMER_TABLE_RET_ID+ 
//				
//				" = "+ Info.RETAILER_TABLE_RET_ID+ " )"	
//				; /
//			
			String qry = "select "+ Info.RETAILER_TABLE_RET_ID + ","+
						Info.RETAILER_TABLE_COMPANY +","+ 
						Info.RETAILER_TABLE_CONTACT1 
						
					+" from "+Info.RETAILER_TABLE + " R where "+Info.RETAILER_TABLE_ASG_RETAILER+  " > "+ 
					" (select count(*) from "+Info.CUSTOMER_TABLE + "  C  WHERE  C."+ Info.CUSTOMER_TABLE_RET_ID+ 
					
					" = R."+ Info.RETAILER_TABLE_RET_ID+ " ) AND " +Info.RETAILER_TABLE_OP_ID+"= ?";	
					; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, (Integer)retailer_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RetailerBean retailer = new RetailerBean();
				
				retailer.setCompany_name(rs.getString(Info.RETAILER_TABLE_COMPANY));
				retailer.setRetailer_id(rs.getInt(Info.RETAILER_TABLE_RET_ID));
				retailer.setContact1(rs.getString(Info.RETAILER_TABLE_CONTACT1));
				
				retailerList.add(retailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return retailerList;

	}
	
	public HashMap<String,Integer> piechart() {
		Connection con = DbCon.getConnection();
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		try {
			String qry = "select company_name, count(*) from argon_infinity_customer ac, argon_infinity_retailer ar where ac.retailer_id = ar.retailer_id group by ar.company_name";
			PreparedStatement ps = con.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				map.put(rs.getString("company_name"), rs.getInt("count(*)"));
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return map;
	}
}
