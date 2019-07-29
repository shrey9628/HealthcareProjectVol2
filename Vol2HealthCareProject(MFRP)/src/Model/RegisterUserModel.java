package Model;

import java.util.Date;

public class RegisterUserModel {
	private int OpNo;
	private String name;
	private String gender;
	private String type;
	private String Benificiary1;
	private String Benificiary2;
	private String address;
	private int age;
	private String email;
	public int getOpNo() {
		return OpNo;
	}
	public void setOpNo(int opNo) {
		OpNo = opNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBenificiary1() {
		return Benificiary1;
	}
	public void setBenificiary1(String benificiary1) {
		Benificiary1 = benificiary1;
	}
	public String getBenificiary2() {
		return Benificiary2;
	}
	public void setBenificiary2(String benificiary2) {
		Benificiary2 = benificiary2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RegisterUserModel(int opNo, String name, String gender, String type, String benificiary1,
			String benificiary2, String address, int age, String email) {
		super();
		OpNo = opNo;
		this.name = name;
		this.gender = gender;
		this.type = type;
		Benificiary1 = benificiary1;
		Benificiary2 = benificiary2;
		this.address = address;
		this.age = age;
		this.email = email;
	}
	public RegisterUserModel() {
		super();
	}
	
	
	
	

}
