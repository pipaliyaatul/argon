package model;

import java.sql.Timestamp;

public class RetailerBean {
	
	private int retailer_id;
	private int operator_id;
	private String company_name;
	private String contact1;
	private String contact2;
	private String address1;
	private String address2;
	private int zipcode;
	private String city;
	private String state;
	private int stb_limit;
	private double credit_limit;
	private double comm_percent;
	private double service_charges;
	//private inventory_list;
	private Timestamp created_on;
	private double inventory_cost;
	private int assigned_to_retailer;
	
	
	public int getRetailer_id() {
		return retailer_id;
	}
	public void setRetailer_id(int retailer_id) {
		this.retailer_id = retailer_id;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getContact1() {
		return contact1;
	}
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}
	public String getContact2() {
		return contact2;
	}
	public void setContact2(String contact2) {
		this.contact2 = contact2;
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
	public int getStb_limit() {
		return stb_limit;
	}
	public void setStb_limit(int stb_limit) {
		this.stb_limit = stb_limit;
	}
	public double getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(double credit_limit) {
		this.credit_limit = credit_limit;
	}
	public double getComm_percent() {
		return comm_percent;
	}
	public void setComm_percent(double comm_percent) {
		this.comm_percent = comm_percent;
	}
	public double getService_charges() {
		return service_charges;
	}
	public void setService_charges(double service_charges) {
		this.service_charges = service_charges;
	}
	public Timestamp getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}
	public double getInventory_cost() {
		return inventory_cost;
	}
	public void setInventory_cost(double inventory_cost) {
		this.inventory_cost = inventory_cost;
	}
	public int getAssigned_to_retailer() {
		return assigned_to_retailer;
	}
	public void setAssigned_to_retailer(int assigned_to_retailer) {
		this.assigned_to_retailer = assigned_to_retailer;
	}

}
