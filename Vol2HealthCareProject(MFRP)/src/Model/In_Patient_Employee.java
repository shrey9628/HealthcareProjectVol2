package Model;

public class In_Patient_Employee {
	 private int opNo;
	 private String name;
	 private int age;
	 private String sex;
	 private String occupation;
	 private String date_of_admission;
	 private String date_of_discharge;
	 private String diagnosis;
	 private String present_complaints;
	 private String patient_history;
	 private String drug_allergy;
	 private double bed_charges;
	 private double xray_charges;
	 private double billing;
	public In_Patient_Employee() {
		super();
	}
	public In_Patient_Employee(int opNo, String name, int age, String sex, String occupation, String date_of_admission,
			String date_of_discharge, String diagnosis, String present_complaints, String patient_history,
			String drug_allergy, double bed_charges, double xray_charges, double billing) {
		super();
		this.opNo = opNo;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.occupation = occupation;
		this.date_of_admission = date_of_admission;
		this.date_of_discharge = date_of_discharge;
		this.diagnosis = diagnosis;
		this.present_complaints = present_complaints;
		this.patient_history = patient_history;
		this.drug_allergy = drug_allergy;
		this.bed_charges = bed_charges;
		this.xray_charges = xray_charges;
		this.billing = billing;
	}
	public int getOpNo() {
		return opNo;
	}
	public void setOpNo(int opNo) {
		this.opNo = opNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDate_of_admission() {
		return date_of_admission;
	}
	public void setDate_of_admission(String date_of_admission) {
		this.date_of_admission = date_of_admission;
	}
	public String getDate_of_discharge() {
		return date_of_discharge;
	}
	public void setDate_of_discharge(String date_of_discharge) {
		this.date_of_discharge = date_of_discharge;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPresent_complaints() {
		return present_complaints;
	}
	public void setPresent_complaints(String present_complaints) {
		this.present_complaints = present_complaints;
	}
	public String getPatient_history() {
		return patient_history;
	}
	public void setPatient_history(String patient_history) {
		this.patient_history = patient_history;
	}
	public String getDrug_allergy() {
		return drug_allergy;
	}
	public void setDrug_allergy(String drug_allergy) {
		this.drug_allergy = drug_allergy;
	}
	public double getBed_charges() {
		return bed_charges;
	}
	public void setBed_charges(double bed_charges) {
		this.bed_charges = bed_charges;
	}
	public double getXray_charges() {
		return xray_charges;
	}
	public void setXray_charges(double xray_charges) {
		this.xray_charges = xray_charges;
	}
	public double getBilling() {
		return billing;
	}
	public void setBilling(double billing) {
		this.billing = billing;
	}
	
	 
	 
	 
	 
	
	
	

}
