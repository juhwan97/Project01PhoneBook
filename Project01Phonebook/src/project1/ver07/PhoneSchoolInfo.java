package project1.ver07;

public class PhoneSchoolInfo extends PhoneInfo {

	String name;
	String phoneNumber;
	String major;//전공
	int grade;//학년
	
	public PhoneSchoolInfo(String name, String phoneNumber,
			String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
}
