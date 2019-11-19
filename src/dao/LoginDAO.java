package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LoginBean;
import utilities.DbCon;
import utilities.Info;

public class LoginDAO {

	public LoginBean validateLogin(LoginBean user) {

		Connection con = DbCon.getConnection();

		try {
			String qry = "select * from " + Info.LOGIN_TABLE + " where " + Info.LOGIN_TABLE_USER_NAME + "=? and "
					+ Info.LOGIN_TABLE_USER_PASSWORD + "=?"; // put query here

			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, user.getUser_name());
			st.setString(2, user.getUser_password());

			ResultSet rs = st.executeQuery();

			if (rs != null && rs.next()) {
				user.setUser_Id(rs.getInt(Info.LOGIN_TABLE_USER_ID));
				user.setUser_name(rs.getString(Info.LOGIN_TABLE_USER_NAME));
				user.setUser_password(rs.getString(Info.LOGIN_TABLE_USER_PASSWORD));
				user.setUser_role_Id(rs.getInt(Info.LOGIN_TABLE_ROLE_ID));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;
	}

	public LoginBean registerUser(LoginBean user) {

		Connection con = DbCon.getConnection();

		try {
			String qry = "Insert into " + Info.LOGIN_TABLE
					+ " (user_name, user_password, user_role_id) values (?, ?,?)";
			// put query here

			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, user.getUser_name());
			st.setString(2, user.getUser_password());
			st.setInt(3, user.getUser_role_Id());
			System.out.println("User role id from Login DAO: " + user.getUser_role_Id());

			int row = st.executeUpdate();

			if (row > 0) {
				return validateLogin(user);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;
	}

	public boolean deleteUser(LoginBean user) {
		Connection con = DbCon.getConnection();
		try {
			String qry = "select " + Info.LOGIN_TABLE_ROLE_ID + " from " + Info.LOGIN_TABLE + " where "
					+ Info.LOGIN_TABLE_USER_ID + "=?";
			// put query here

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, user.getUser_Id());

			ResultSet rs = st.executeQuery();

			if (rs != null && rs.next()) {
				int role_id = rs.getInt(Info.LOGIN_TABLE_ROLE_ID);

				System.out.println(role_id);
				String table_name = null;
				String id_column = null;
				if (role_id == Info.CUSTOMER_ROLE_ID) {
					table_name = Info.CUSTOMER_TABLE;
					id_column = Info.CUSTOMER_TABLE_CUST_ID;
				} else if (role_id == Info.RETAILER_ROLE_ID) {
					table_name = Info.RETAILER_TABLE;
					id_column = Info.RETAILER_TABLE_RET_ID;
				} else if (role_id == Info.OPERATOR_ROLE_ID) {
					table_name = Info.OPERATOR_TABLE;
					id_column = Info.OPERATOR_TABLE_OP_ID;
				} else {
					return false;
				}
				qry = "delete from " + table_name + " where " + id_column + "=?";
				st = con.prepareStatement(qry);
				st.setInt(1, user.getUser_Id());
				int flag = st.executeUpdate();
				if (flag > 0) {
					qry = "delete from " + Info.LOGIN_TABLE + " where " + Info.LOGIN_TABLE_USER_ID + "= ?";
					st = con.prepareStatement(qry);
					st.setInt(1, user.getUser_Id());
					flag = st.executeUpdate();
					if (flag > 0) {
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return false;
	}

	public boolean changePassword(LoginBean user) {
		Connection con = DbCon.getConnection();
		try {
			String qry = "update " + Info.LOGIN_TABLE + " set " + Info.LOGIN_TABLE_USER_PASSWORD + "=?  " + "where "
					+ Info.LOGIN_TABLE_USER_ID + "=?";
			// put query here

			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, user.getUser_password());
			st.setInt(2, user.getUser_Id());

			int flag = st.executeUpdate();
			if (flag > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return false;
	}

	public String getRetailerForCustomer(LoginBean user) {

		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();

		try {
			// select company_name from (select * from argon_infinity_customer
			// where customer_id=?) c
			// inner join argon_infinity_retailer r
			// on r.retailer_id = c.retailer_id

			String qry = "select " + Info.RETAILER_TABLE_COMPANY + " from (SELECT * FROM " + Info.CUSTOMER_TABLE
					+ " WHERE " + Info.CUSTOMER_TABLE_CUST_ID + " =? ) C INNER JOIN  " + Info.RETAILER_TABLE
					+ " R ON R." + Info.RETAILER_TABLE_RET_ID + " = " + " C." + Info.CUSTOMER_TABLE_RET_ID;

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, user.getUser_Id());
			// st.setString(2, user.getUser_password());

			ResultSet rs = st.executeQuery();

			if (rs != null && rs.next()) {
				return rs.getString(Info.RETAILER_TABLE_COMPANY);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;
	}

	public String getOperatorForCustomer(LoginBean user) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();

		try {

			String qry = "select O." + Info.OPERATOR_TABLE_FIRST_NAME + " from (SELECT * FROM " + Info.CUSTOMER_TABLE
					+ " WHERE " + Info.CUSTOMER_TABLE_CUST_ID + " =? ) C INNER JOIN  " + Info.OPERATOR_TABLE
					+ " O ON O." + Info.OPERATOR_TABLE_OP_ID + " = " + " C." + Info.CUSTOMER_TABLE_OP_ID;

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, user.getUser_Id());

			ResultSet rs = st.executeQuery();

			if (rs != null && rs.next()) {
				return rs.getString(Info.OPERATOR_TABLE_FIRST_NAME);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;
	}

}
