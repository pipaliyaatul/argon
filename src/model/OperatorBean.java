package model;

import java.sql.Timestamp;

public class OperatorBean 
{
	private int operator_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private long phone;
	private String shift_start_time;
	private String shift_end_time;
	private int customer_limit;
	private Timestamp created_on;
	private int total_active_customer;
	
	public OperatorBean(){
		super();
	}
	public OperatorBean(int operator_id, String first_name, String last_name, String email_id, long phone,
			String shift_start_time, String shift_end_time, int customer_limit, Timestamp created_on,
			int total_active_customer) 
	{
		super();
		this.operator_id = operator_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone = phone;
		this.shift_start_time = shift_start_time;
		this.shift_end_time = shift_end_time;
		this.customer_limit = customer_limit;
		this.created_on = created_on;
		this.total_active_customer = total_active_customer;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
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

	public String getShift_start_time() {
		return shift_start_time;
	}

	public void setShift_start_time(String shift_start_time) {
		this.shift_start_time = shift_start_time;
	}

	public String getShift_end_time() {
		return shift_end_time;
	}

	public void setShift_end_time(String shift_end_time) {
		this.shift_end_time = shift_end_time;
	}

	public int getCustomer_limit() {
		return customer_limit;
	}

	public void setCustomer_limit(int customer_limit) {
		this.customer_limit = customer_limit;
	}

	public String getCreated_on() {
//		java.sql.Timestamp.valueOf(dateTime)
		System.out.println("Hey Siri: "+created_on);
		return created_on.toString();
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public int getTotal_active_customer() {
		return total_active_customer;
	}

	public void setTotal_active_customer(int total_active_customer) {
		this.total_active_customer = total_active_customer;
	}
	

	
	

}
