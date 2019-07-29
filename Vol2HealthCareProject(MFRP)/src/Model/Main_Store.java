package Model;

import java.util.Date;

public class Main_Store {

	
	private String drug_name;
	private int  in_store;
	private Date Expiry_Date_1;
	private Date Expiry_Date_2;
	public Main_Store() {
		super();
	}
	public Main_Store(String drug_name, int in_store, Date expiry_Date_1, Date expiry_Date_2) {
		super();
		this.drug_name = drug_name;
		this.in_store = in_store;
		Expiry_Date_1 = expiry_Date_1;
		Expiry_Date_2 = expiry_Date_2;
	}
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public int getIn_store() {
		return in_store;
	}
	public void setIn_store(int in_store) {
		this.in_store = in_store;
	}
	public Date getExpiry_Date_1() {
		return Expiry_Date_1;
	}
	public void setExpiry_Date_1(Date expiry_Date_1) {
		Expiry_Date_1 = expiry_Date_1;
	}
	public Date getExpiry_Date_2() {
		return Expiry_Date_2;
	}
	public void setExpiry_Date_2(Date expiry_Date_2) {
		Expiry_Date_2 = expiry_Date_2;
	}
		
	
}
