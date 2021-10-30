package project1.ver08;

import java.util.Objects;

public class PhoneInfo {

	public String name;//이름
	public String phoneNumber;//전화번호
	public String major;
	public int grade;
	public String company;

	
	public PhoneInfo() {}
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	
	}
	
	
	public PhoneInfo(String name, String phoneNumber, String major, int grade) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
	}
	


	public PhoneInfo(String name, String phoneNumber, String company) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.company = company;
	}

	public String getName() { return name; }
	public String getPhone() { return phoneNumber; }
	public String getMajor() { return major; }
	public int getGrade() { return grade; }
	public String getCompany() { return company; }
	public String setName(String name) { return this.name=name; }
	public String setPhone(String phoneNumber) { return this.phoneNumber=phoneNumber; }
	public String setMajor(String major) { return this.major=major; }
	public int setGrade(int grade) { return this.grade=grade;}
	public String setCompany(String company) { return this.company=company; }

	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
		System.out.println("회사명:"+ company);
	
	}
	
	@Override
	public String toString() {
		return "정보:"+getName()+"/"+getPhone()+"/"+getMajor()+"/"+getGrade()+"/"+getCompany();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PhoneInfo)) {
			return false;
		}
		PhoneInfo pi = (PhoneInfo) obj;
		return Objects.equals(name, pi.name);
	}
	
}