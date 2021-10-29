package project1.ver08;

import java.util.Objects;

public class PhoneInfo {

	String name;//이름
	String phoneNumber;//전화번호
	String major;
	int grade;
	String company;

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


	public PhoneInfo(String name, String phoneNumber, String major, int grade, String company) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.company = company;
	}


	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
		System.out.println("회사명:"+ company);
	
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
