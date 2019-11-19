package model;

import java.sql.Timestamp;

public class CustomerBean {
	private int customer_id;
	private int operator_id;
	private int retailer_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private long phone;
	private String address1;
	private String address2;
	private int zipcode;
	private String city;
	private String state;
	//private String created_on; //edited by pranav
	private Timestamp created_on;
	
	

	public CustomerBean(int customer_id, int operator_id, int retailer_id, String first_name, String last_name,
			String email_id, long phone, String address1, String address2, int zipcode, String city, String state,
			Timestamp created_on) {
		super();
		this.customer_id = customer_id;
		this.operator_id = operator_id;
		this.retailer_id = retailer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.created_on = created_on;
	}
	
	
	public CustomerBean() {
		super();
	}


	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public int getRetailer_id() {
		return retailer_id;
	}
	public void setRetailer_id(int retailer_id) {
		this.retailer_id = retailer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreated_on() {
		return created_on.toString();
	}
	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}
	
	

}
