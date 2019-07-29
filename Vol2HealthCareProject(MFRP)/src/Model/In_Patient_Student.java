package Model;

public class In_Patient_Student {
	private int opNo;
	private String name;
	private int age;
	private String sex;
	private String occupation;
	private String date_of_admission;
	private String date_of_discharge;
	private  String diagnosis;
	private String present_complaint;
	private String patient_history;
	private String drugs_allergy;
	public In_Patient_Student() {
		super();
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
	public String getPresent_complaint() {
		return present_complaint;
	}
	public void setPresent_complaint(String present_complaint) {
		this.present_complaint = present_complaint;
	}
	public String getPatient_history() {
		return patient_history;
	}
	public void setPatient_history(String patient_history) {
		this.patient_history = patient_history;
	}
	public String getDrugs_allergy() {
		return drugs_allergy;
	}
	public void setDrugs_allergy(String drugs_allergy) {
		this.drugs_allergy = drugs_allergy;
	}
	public In_Patient_Student(int opNo, String name, int age, String sex, String occupation, String date_of_admission,
			String date_of_discharge, String diagnosis, String present_complaint, String patient_history,
			String drugs_allergy) {
		super();
		this.opNo = opNo;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.occupation = occupation;
		this.date_of_admission = date_of_admission;
		this.date_of_discharge = date_of_discharge;
		this.diagnosis = diagnosis;
		this.present_complaint = present_complaint;
		this.patient_history = patient_history;
		this.drugs_allergy = drugs_allergy;
	}
	
	

}
