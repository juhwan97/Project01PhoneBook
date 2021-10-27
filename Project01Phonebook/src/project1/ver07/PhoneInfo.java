package project1.ver07;

public class PhoneInfo {

	String name;//이름
	String phoneNumber;//전화번호
	String major;
	int grade;
	String company;

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


	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
		System.out.println("회사명:"+ company);
	
	}

	public int hashCode() {
		int nameHashCode = name.hashCode();
		return nameHashCode;
	}
	public boolean equals(Object obj) {
		PhoneInfo ph = (PhoneInfo)obj;
		if(ph.name.equals(this.name)) {
			return true;
		}
		else return false;
	}
	
	
}
