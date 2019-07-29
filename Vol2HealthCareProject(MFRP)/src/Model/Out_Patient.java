package Model;

public class Out_Patient {
	
	private int Op_No;
	private String name;
	private int age;
	private String type;
	private String date_of_admission;
	private String sex;
	private String diagnosis;
	private String treatment;
	public Out_Patient() {
		super();
	}
	public Out_Patient(int op_No, String name, int age, String type, String date_of_admission, String sex,
			String diagnosis, String treatment) {
		super();
		Op_No = op_No;
		this.name = name;
		this.age = age;
		this.type = type;
		this.date_of_admission = date_of_admission;
		this.sex = sex;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}
	public int getOp_No() {
		return Op_No;
	}
	public void setOp_No(int op_No) {
		Op_No = op_No;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate_of_admission() {
		return date_of_admission;
	}
	public void setDate_of_admission(String date_of_admission) {
		this.date_of_admission = date_of_admission;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
	
	
	

}
