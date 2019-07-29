package Model;

public class OperatorEntry {
	private int Op_No;
	private String Drug_Name;
	private String date;
	private int No_Of_Drugs;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNo_Of_Drugs() {
		return No_Of_Drugs;
	}
	public void setNo_Of_Drugs(int no_Of_Drugs) {
		No_Of_Drugs = no_Of_Drugs;
	}
	public OperatorEntry(int op_No, String drug_Name, String date, int no_Of_Drugs) {
		super();
		Op_No = op_No;
		Drug_Name = drug_Name;
		this.date = date;
		No_Of_Drugs = no_Of_Drugs;
	}
	public OperatorEntry() {
		super();
	}
	
	

}
