package dao;

import java.sql.Connection;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import model.CustomerBean;
import utilities.DbCon;
import utilities.Info;

//Code in Progress with PRANAV
public class CustomerDAO {
	
	public ArrayList<CustomerBean> getAllCustomer() {
		Connection con = DbCon.getConnection();
		ArrayList<CustomerBean> customerList = new ArrayList<CustomerBean>();
		try {
			String qry = "select * from "+Info.CUSTOMER_TABLE; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setFirst_name(rs.getString(Info.CUSTOMER_TABLE_FNAME));
				customer.setLast_name(rs.getString(Info.CUSTOMER_TABLE_LNAME));
				customer.setCustomer_id(rs.getInt(Info.CUSTOMER_TABLE_CUST_ID));
				customer.setPhone(rs.getLong(Info.CUSTOMER_TABLE_PHONE));
				customerList.add(customer);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return customerList;
	}

	public int insertCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		int code=0;
		Connection con = DbCon.getConnection();
		try {
			String qry = "INSERT INTO "+Info.CUSTOMER_TABLE +" (CUSTOMER_ID,OPERATOR_ID,RETAILER_ID,FIRST_NAME,LAST_NAME"
					+ ",EMAIL_ID,PHONE,ADDRESS1,ADDRESS2,ZIPCODE,CITY,STATE,CREATED_ON) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, customer.getCustomer_id());
			ps.setInt(2, customer.getOperator_id());
			ps.setInt(3, customer.getRetailer_id());
			ps.setString(4, customer.getFirst_name());
			ps.setString(5, customer.getLast_name());
			ps.setString(6, customer.getEmail_id());
			ps.setLong(7, customer.getPhone());
			ps.setString(8, customer.getAddress1());
			ps.setString(9, customer.getAddress2());
			ps.setInt(10, customer.getZipcode());
			ps.setString(11, customer.getCity());
			ps.setString(12, customer.getState());
			ps.setTimestamp(13, java.sql.Timestamp.valueOf(customer.getCreated_on()));
			
			code=ps.executeUpdate();
			
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return code;
	}
	
	public int insertCustomerBySelf(CustomerBean customer) {
		// TODO Auto-generated method stub
		int code=0;
		Connection con = DbCon.getConnection();
		try {
			String qry = "INSERT INTO "+Info.CUSTOMER_TABLE +" (CUSTOMER_ID,OPERATOR_ID,RETAILER_ID,FIRST_NAME,LAST_NAME"
					+ ",EMAIL_ID,PHONE,ADDRESS1,ADDRESS2,ZIPCODE,CITY,STATE,CREATED_ON) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, customer.getCustomer_id());
			ps.setInt(2, customer.getOperator_id());
			ps.setInt(3, customer.getRetailer_id());
			ps.setString(4, customer.getFirst_name());
			ps.setString(5, customer.getLast_name());
			ps.setString(6, customer.getEmail_id());
			ps.setLong(7, customer.getPhone());
			ps.setString(8, customer.getAddress1());
			ps.setString(9, customer.getAddress2());
			ps.setInt(10, customer.getZipcode());
			ps.setString(11, customer.getCity());
			ps.setString(12, customer.getState());
			ps.setTimestamp(13, java.sql.Timestamp.valueOf(customer.getCreated_on()));
			
			code=ps.executeUpdate();
			
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return code;
	}
	public CustomerBean getCustomerById(int id) {
		System.out.println("inside getCustbyId");
		Connection con = DbCon.getConnection();
		CustomerBean customer = new CustomerBean();
		try {
			
			String qry = "select * from "+Info.CUSTOMER_TABLE + " WHERE CUSTOMER_ID = ?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomer_id(rs.getInt(Info.CUSTOMER_TABLE_CUST_ID));
				customer.setOperator_id(rs.getInt(Info.CUSTOMER_TABLE_OP_ID));
				customer.setRetailer_id(rs.getInt(Info.CUSTOMER_TABLE_RET_ID));
				customer.setFirst_name(rs.getString(Info.CUSTOMER_TABLE_FNAME));
				
				
				System.out.println("FIRST NAME IS :"+rs.getString(Info.CUSTOMER_TABLE_FNAME));
				customer.setLast_name(rs.getString(Info.CUSTOMER_TABLE_LNAME));
				customer.setEmail_id(rs.getString(Info.CUSTOMER_TABLE_EMAIL));
				customer.setPhone(rs.getLong(Info.CUSTOMER_TABLE_PHONE));
				customer.setAddress1(rs.getString(Info.CUSTOMER_TABLE_ADD1));
				customer.setAddress2(rs.getString(Info.CUSTOMER_TABLE_ADD2));
				customer.setZipcode(rs.getInt(Info.CUSTOMER_TABLE_ZIP));
				customer.setCity(rs.getString(Info.CUSTOMER_TABLE_CITY));
				customer.setState(rs.getString(Info.CUSTOMER_TABLE_STATE));
				customer.setCreated_on(rs.getTimestamp(Info.CUSTOMER_TABLE_CREATED));
				System.out.println(customer.getCreated_on());
				
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return customer;
	}

	public int updateCustomer(CustomerBean customer, int id) {
		int code=0;
		Connection con = DbCon.getConnection();
		try {
				
			String qry = "UPDATE "+ Info.CUSTOMER_TABLE +" SET "
					+ "FIRST_NAME=?,LAST_NAME=?,EMAIL_ID=?,PHONE=?,ADDRESS1=?,ADDRESS2=?,ZIPCODE=?,CITY=?,"
					+ "STATE=?  WHERE CUSTOMER_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
		//	ps.setInt(1, customer.getCustomer_id());
		//	ps.setInt(2, customer.getOperator_id());
		//	ps.setInt(3, customer.getRetailer_id());
			ps.setString(1, customer.getFirst_name());
			ps.setString(2, customer.getLast_name());
			ps.setString(3, customer.getEmail_id());
			ps.setLong(4, customer.getPhone());
			ps.setString(5, customer.getAddress1());
			ps.setString(6, customer.getAddress2());
			ps.setInt(7, customer.getZipcode());
			ps.setString(8, customer.getCity());
			ps.setString(9, customer.getState());
	//		ps.setTimestamp(13, java.sql.Timestamp.valueOf(customer.getCreated_on()));
			ps.setInt(10, id);
			
			code=ps.executeUpdate();
			
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return code;
	}
	
	public LinkedHashMap<String,Integer> barchart() {
		Connection con = DbCon.getConnection();
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		LinkedHashMap<String,Integer> map1 = new LinkedHashMap<String,Integer>(); 
		try {
			String qry = "Select extract(month from created_on) as mon, extract(year from created_on) as yr, count(*) from argon_infinity_customer where created_on > add_months(trunc(sysdate, 'month'), - 12)"
					+ "and created_on <= add_months(trunc(sysdate, 'month'),1) group by extract(month from created_on), extract(year from created_on)";
			PreparedStatement ps = con.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int x = rs.getInt("mon");
				int yr = rs.getInt("yr");	
				String s = Month.of(x).name();
				s = s + " " + String.valueOf(yr);
				System.out.println(s + rs.getInt("count(*)"));
				map.put(s, rs.getInt("count(*)"));
				
			}
			DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM u", Locale.ENGLISH);
		    YearMonth current = YearMonth.of(y, m);
		    current = current.minusMonths(11);
		    for (int i = 0; i < 12 ; i++) {
		    	
		        if(!map.containsKey(current.format(monthFormatter).toUpperCase()))
		        	map1.put(current.format(monthFormatter), 0);
		        else{
		        	map1.put(current.format(monthFormatter), map.get(current.format(monthFormatter).toUpperCase()));}
		        
		        current = current.plusMonths(1);
		    }
		    
		   
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return map1;
	}

	public ArrayList<CustomerBean> getAllUnassignedRetailer() {
		Connection con = DbCon.getConnection();
		ArrayList<CustomerBean> customerList = new ArrayList<CustomerBean>();
		try {
			String qry = "select * from "+Info.CUSTOMER_TABLE + " where RETAILER_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setInt(1, Info.DEFAULT_RETAILER_ID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomer_id(rs.getInt(Info.CUSTOMER_TABLE_CUST_ID));
				customer.setOperator_id(rs.getInt(Info.CUSTOMER_TABLE_OP_ID));
				customer.setRetailer_id(rs.getInt(Info.CUSTOMER_TABLE_RET_ID));
				customer.setFirst_name(rs.getString(Info.CUSTOMER_TABLE_FNAME));
				customer.setLast_name(rs.getString(Info.CUSTOMER_TABLE_LNAME));
				customer.setEmail_id(rs.getString(Info.CUSTOMER_TABLE_EMAIL));
				customer.setPhone(rs.getLong(Info.CUSTOMER_TABLE_PHONE));
				customer.setAddress1(rs.getString(Info.CUSTOMER_TABLE_ADD1));
				customer.setAddress2(rs.getString(Info.CUSTOMER_TABLE_ADD2));
				customer.setZipcode(rs.getInt(Info.CUSTOMER_TABLE_ZIP));
				customer.setCity(rs.getString(Info.CUSTOMER_TABLE_CITY));
				customer.setState(rs.getString(Info.CUSTOMER_TABLE_STATE));
				customer.setCreated_on(rs.getTimestamp(Info.CUSTOMER_TABLE_CREATED));
				customerList.add(customer);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return customerList;
	}

	
	public ArrayList<CustomerBean> getAllUnassignedOperator() {
		Connection con = DbCon.getConnection();
		ArrayList<CustomerBean> customerList = new ArrayList<CustomerBean>();
		try {
			String qry = "select * from "+Info.CUSTOMER_TABLE + " where OPERATOR_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setInt(1, Info.DEFAULT_OPERATOR_ID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomer_id(rs.getInt(Info.CUSTOMER_TABLE_CUST_ID));
				customer.setOperator_id(rs.getInt(Info.CUSTOMER_TABLE_OP_ID));
				customer.setRetailer_id(rs.getInt(Info.CUSTOMER_TABLE_RET_ID));
				customer.setFirst_name(rs.getString(Info.CUSTOMER_TABLE_FNAME));
				customer.setLast_name(rs.getString(Info.CUSTOMER_TABLE_LNAME));
				customer.setEmail_id(rs.getString(Info.CUSTOMER_TABLE_EMAIL));
				customer.setPhone(rs.getLong(Info.CUSTOMER_TABLE_PHONE));
				customer.setAddress1(rs.getString(Info.CUSTOMER_TABLE_ADD1));
				customer.setAddress2(rs.getString(Info.CUSTOMER_TABLE_ADD2));
				customer.setZipcode(rs.getInt(Info.CUSTOMER_TABLE_ZIP));
				customer.setCity(rs.getString(Info.CUSTOMER_TABLE_CITY));
				customer.setState(rs.getString(Info.CUSTOMER_TABLE_STATE));
				customer.setCreated_on(rs.getTimestamp(Info.CUSTOMER_TABLE_CREATED));
				customerList.add(customer);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return customerList;
	}

	
	
	public ArrayList<CustomerBean> getAllCustomer(int op_id) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		ArrayList<CustomerBean> customerList = new ArrayList<CustomerBean>();
		try {
			String qry = "select * from "+Info.CUSTOMER_TABLE + " where OPERATOR_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, op_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomer_id(rs.getInt(Info.CUSTOMER_TABLE_CUST_ID));
				customer.setOperator_id(rs.getInt(Info.CUSTOMER_TABLE_OP_ID));
				customer.setRetailer_id(rs.getInt(Info.CUSTOMER_TABLE_RET_ID));
				customer.setFirst_name(rs.getString(Info.CUSTOMER_TABLE_FNAME));
				customer.setLast_name(rs.getString(Info.CUSTOMER_TABLE_LNAME));
				customer.setEmail_id(rs.getString(Info.CUSTOMER_TABLE_EMAIL));
				customer.setPhone(rs.getLong(Info.CUSTOMER_TABLE_PHONE));
				customer.setAddress1(rs.getString(Info.CUSTOMER_TABLE_ADD1));
				customer.setAddress2(rs.getString(Info.CUSTOMER_TABLE_ADD2));
				customer.setZipcode(rs.getInt(Info.CUSTOMER_TABLE_ZIP));
				customer.setCity(rs.getString(Info.CUSTOMER_TABLE_CITY));
				customer.setState(rs.getString(Info.CUSTOMER_TABLE_STATE));
				customer.setCreated_on(rs.getTimestamp(Info.CUSTOMER_TABLE_CREATED));
				customerList.add(customer);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return customerList;
	}
	
	public boolean updateAssignedRetailer(int customer_id,int retailer_id) {
		// TODO Auto-generated method stub
		int code=0;
		Connection con = DbCon.getConnection();
		try {
				
			String qry = "UPDATE "+ Info.CUSTOMER_TABLE +" SET "
					+Info.CUSTOMER_TABLE_RET_ID+"=?  WHERE CUSTOMER_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, retailer_id);
			ps.setInt(2, customer_id);
			code=ps.executeUpdate();
			if(code>0){
				con.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return false;
	}

	public boolean updateAssignedOperator(int customer_id, int operator_id) {
		int code=0;
		Connection con = DbCon.getConnection();
		try {
				
			String qry = "UPDATE "+ Info.CUSTOMER_TABLE +" SET "
					+Info.CUSTOMER_TABLE_OP_ID+"=?  WHERE CUSTOMER_ID=?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, operator_id);
			ps.setInt(2, customer_id);
			code=ps.executeUpdate();
			if(code>0){
				con.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return false;
	}
	
}
