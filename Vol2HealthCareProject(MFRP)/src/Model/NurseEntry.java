package Model;

public class NurseEntry {
	private int Op_No;
	private String Drug_Name;
	private String Med_Given_date;
	private String Time;
	private int Quantity;
	public int getOp_No() {
		return Op_No;
	}
	public void setOp_No(int op_No) {
		Op_No = op_No;
	}
	public String getDrug_Name() {
		return Drug_Name;
	}
	public void setDrug_Name(String drug_Name) {
		Drug_Name = drug_Name;
	}
	public String getMed_Given_date() {
		return Med_Given_date;
	}
	public void setMed_Given_date(String med_Given_date) {
		Med_Given_date = med_Given_date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public NurseEntry(int op_No, String drug_Name, String med_Given_date, String time, int quantity) {
		super();
		Op_No = op_No;
		Drug_Name = drug_Name;
		Med_Given_date = med_Given_date;
		Time = time;
		Quantity = quantity;
	}
	public NurseEntry() {
		super();
	}
	
	

}
