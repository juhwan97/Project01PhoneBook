package project1.ver05;

public class PhoneInfo {
	String name;
	String phoneNumber;
	//String birthday;
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		//this.birthday="입력되지않음";
	}
	/*
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	*/
	
	public void showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		//System.out.println("생년월일:"+ birthday);
	}
	
}
