package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CustomerBean;
import model.LoginBean;
import model.OperatorBean;
import service.InfinityService;
import utilities.DbCon;
import utilities.Info;

public class OperatorDAO {
	
	public ArrayList<OperatorBean> getAllOperator() {
		Connection con = DbCon.getConnection();
		ArrayList<OperatorBean> operatorList = new ArrayList<OperatorBean>();
		try {
			String qry = "Select * from "+Info.OPERATOR_TABLE; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OperatorBean operator = new OperatorBean();
				operator.setOperator_id(rs.getInt(Info.OPERATOR_TABLE_OP_ID));
				operator.setFirst_name(rs.getString(Info.OPERATOR_TABLE_FIRST_NAME));
				operator.setLast_name(rs.getString(Info.OPERATOR_TABLE_LAST_NAME));
				operator.setEmail_id(rs.getString(Info.OPERATOR_TABLE_EMAIL));
				operator.setOperator_id(rs.getInt(Info.OPERATOR_TABLE_OP_ID));
				
				operatorList.add(operator);		
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return operatorList;
	}
	
	public int insertOperator(OperatorBean operator) {
		// TODO Auto-generated method stub
		LoginBean user = new LoginBean();
		user.setUser_name(operator.getEmail_id());
		user.setUser_password(Info.DEFAULT_PASSWORD);
		user.setUser_role_Id(Info.OPERATOR_ROLE_ID);
		InfinityService service = new InfinityService();
		int user_id = service.registerUser(user).getUser_Id();
		int code=0;
		Connection con = DbCon.getConnection();
		try {
			String qry = "INSERT INTO "+Info.OPERATOR_TABLE +" (OPERATOR_ID,FIRST_NAME,LAST_NAME"
					+ ",EMAIL_ID,PHONE,SHIFT_START_TIME,SHIFT_END_TIME,CUSTOMER_LIMIT, CREATED_ON,TOTAL_ACTIVE_CUSTOMER)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, user_id);
			ps.setString(2, operator.getFirst_name());
			ps.setString(3, operator.getLast_name());
			ps.setString(4, operator.getEmail_id());
			ps.setLong(5, operator.getPhone());
			ps.setString(6, operator.getShift_start_time());
			ps.setString(7, operator.getShift_end_time());
			System.out.println(operator.getShift_end_time());
			ps.setInt(8, operator.getCustomer_limit());
			ps.setTimestamp(9, java.sql.Timestamp.valueOf(operator.getCreated_on()));
			ps.setInt(10, operator.getTotal_active_customer());
			
			code=ps.executeUpdate();
			
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return code;
	}
public OperatorBean getOperatorByID(OperatorBean operator){
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "Select * from "+Info.OPERATOR_TABLE+ " where "+Info.OPERATOR_TABLE_OP_ID+" =?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, operator.getOperator_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				operator.setFirst_name(rs.getString(Info.OPERATOR_TABLE_FIRST_NAME));
				operator.setLast_name(rs.getString(Info.OPERATOR_TABLE_LAST_NAME));
				operator.setEmail_id(rs.getString(Info.OPERATOR_TABLE_EMAIL));
				operator.setOperator_id(rs.getInt(Info.OPERATOR_TABLE_OP_ID));
				operator.setPhone(rs.getLong(Info.OPERATOR_TABLE_PHONE));
				operator.setShift_start_time(rs.getString(Info.OPERATOR_TABLE_SSTART));
				operator.setShift_end_time(rs.getString(Info.OPERATOR_TABLE_SEND));
				operator.setTotal_active_customer(rs.getInt(Info.OPERATOR_TABLE_TOTAL_CUST));
				operator.setCreated_on( rs.getTimestamp(Info.OPERATOR_TABLE_CON));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return getOperatorAssignedCustomerCount(operator);
	}

public OperatorBean getOperatorAssignedCustomerCount(OperatorBean operator){
	Connection con = DbCon.getConnection();
	
	try {
		String qry = "Select count(*) from "+Info.CUSTOMER_TABLE+ " where "+Info.CUSTOMER_TABLE_OP_ID+" =?"; // put query here
		PreparedStatement ps = con.prepareStatement(qry);
		ps.setInt(1, operator.getOperator_id());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			operator.setTotal_active_customer(rs.getInt(1));			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DbCon.closeConnection();
	}
	return operator;	
}
	
	public int updateOperator(OperatorBean operator){
		Connection con = DbCon.getConnection();
		int result =0;
		
		try {
			String qry = "Update "+Info.OPERATOR_TABLE+ " set FIRST_NAME=?, LAST_NAME=?, EMAIL_ID=?, "
					+ "PHONE=?, TOTAL_ACTIVE_CUSTOMER=?, SHIFT_END_TIME=?, SHIFT_START_TIME=? where OPERATOR_ID = ?"; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, operator.getFirst_name());
			ps.setString(2, operator.getLast_name());
			ps.setString(3, operator.getEmail_id());
			ps.setLong(4, operator.getPhone());
			ps.setInt(5, operator.getTotal_active_customer());
			ps.setString(6, operator.getShift_end_time());
			ps.setString(7, operator.getShift_start_time());
			ps.setInt(8, operator.getOperator_id());
			
			result = ps.executeUpdate();
			System.out.println(result);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return result;
		
	}
	
	public ArrayList<OperatorBean> getAllOperatorAvailable() {
		Connection con = DbCon.getConnection();
		ArrayList<OperatorBean> operatorList = new ArrayList<OperatorBean>();
		try {
			
//			
			String qry = "select "+ Info.OPERATOR_TABLE_FIRST_NAME + ","+
						Info.OPERATOR_TABLE_LAST_NAME +","+ 
						Info.OPERATOR_TABLE_EMAIL+","+
						Info.OPERATOR_TABLE_PHONE+","+
						Info.OPERATOR_TABLE_OP_ID
						
					+" from "+Info.OPERATOR_TABLE + " O where "+Info.OPERATOR_TABLE_CLIMIT+  " > "+ 
					" (select count(*) from "+Info.CUSTOMER_TABLE + "  C  WHERE  C."+ Info.CUSTOMER_TABLE_OP_ID+ 
					
					" = O."+ Info.OPERATOR_TABLE_OP_ID+ " )"	
					; // put query here
			PreparedStatement ps = con.prepareStatement(qry);
//			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OperatorBean operator = new OperatorBean();

				operator.setOperator_id(rs.getInt(Info.OPERATOR_TABLE_OP_ID));
				operator.setFirst_name(rs.getString(Info.OPERATOR_TABLE_FIRST_NAME));
				operator.setLast_name(rs.getString(Info.OPERATOR_TABLE_LAST_NAME));
				operator.setEmail_id(rs.getString(Info.OPERATOR_TABLE_EMAIL));
				operator.setPhone(rs.getLong(Info.OPERATOR_TABLE_PHONE));
				operatorList.add(operator);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return operatorList;
	}
	

	
}
