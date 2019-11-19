package model;

public class LoginBean {
	private int user_Id;
	private String user_name;
	private String user_password;
	private int user_role_Id;
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_role_Id() {
		return user_role_Id;
	}
	public void setUser_role_Id(int user_role_Id) {
		this.user_role_Id = user_role_Id;
	}

}
